package projectGetClass;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Get {
    String hostName = "localhost:9092";
    String topicRequest = "request";
    long ID;

    public void StartRequest() throws InterruptedException {
        Properties properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, hostName);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        try (KafkaProducer<Long, String> producer =
                     new KafkaProducer<Long, String>(properties)) {
            int i = 0;
            while (true) {
                long key = ID;
                String message = "Message : " + i;

                ProducerRecord<Long, String> record =
                        new ProducerRecord<Long, String>(topicRequest, key, message);

                producer.send(record);
                TimeUnit.SECONDS.sleep(5);
                i++;

                producer.flush();
            }
        }
    }

    public void StartResponse() {
        Properties properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, hostName);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        try (KafkaConsumer<Long, String> consumer =
                     new KafkaConsumer<Long, String>(properties)) {
            consumer.subscribe(Arrays.asList(topicRequest));

            while (true) {
                ConsumerRecords<Long, String> records = consumer.poll(100);

                for (ConsumerRecord<Long, String> record: records) {
                    long key = record.key();
                    String message = record.value();

                    System.out.println("Consumer received : ");
                    System.out.println("--------------------");
                    System.out.println("ID : " + key);
                    System.out.println("Message : " + message);
                }
            }
        }
    }
}
