//package prj2;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.Properties;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//
//public class JavaKafkaConsumer {
//
//    public void start(String bootstratServer, String consumerGroup, List<String> topics) {
//        Properties properties = new Properties();
//
//        // Populate consumer configurations
//        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstratServer);
//        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        properties.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroup);
//        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//
//        // Instantiate consumer
//        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties)) {
//            // Subscribe to the topics
//            consumer.subscribe(topics);
//
//            while (true) {
//                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
//
//                for (ConsumerRecord<String, String> record : records) {
//                    String key = record.key();
//                    String value = record.value();
//                    long offset = record.offset();
//
//                    System.out.println("\n\nConsumer received : ");
//                    System.out.println("----------------------");
//                    System.out.println("key : " + key);
//                    System.out.println("value : " + value);
//                    System.out.println("offset : " + offset);
//
//                }
//            }
//
//        }
//
//    }
//}
