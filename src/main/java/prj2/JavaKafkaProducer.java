package prj2;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
////
////import org.apache.kafka.clients.producer.KafkaProducer;
////import org.apache.kafka.clients.producer.ProducerConfig;
////import org.apache.kafka.clients.producer.ProducerRecord;
////import org.apache.kafka.common.serialization.StringSerializer;
////
////public class JavaKafkaProducer {
////
////    public void start(String bootstratServer, String topicName) throws InterruptedException {
////        Properties properties = new Properties();
////
////        // Populate producer configurations
////        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstratServer);
////        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
////        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
////        properties.put(ProducerConfig.ACKS_CONFIG, "1");
////
////        // Initialize KafkaProducer with configurations
////        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
////            int i = 0;
////            while (true) {
////                String key = "key-" + (i % 3);
////                String message = "Message : " + i;
////
////                ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, message);
////
////                producer.send(record);
////                TimeUnit.SECONDS.sleep(5);
////                i++;
////
////            }
////
////            // producer.flush(): Since this operation is asynchronous, you need to either
////            // flush or close the producer to publish the data. try-with-resource statement
////            // automatically close the prodcuer
////        }
////    }
////
//}