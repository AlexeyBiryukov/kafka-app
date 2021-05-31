package prj1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SampleProducer {
    public SampleProducer() {

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer kafkaProducer =
                new KafkaProducer(properties);

        for (int i = 0; i < 10 ; i++) {
            ProducerRecord producerRecord =
                    new ProducerRecord("channel", "key_" + i, "Message_" + i);
            kafkaProducer.send(producerRecord);
        }
        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
