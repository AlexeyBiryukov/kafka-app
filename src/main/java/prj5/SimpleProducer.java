//package prj5;
//
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.common.serialization.LongSerializer;
//
//import java.io.Serializable;
//import java.util.Properties;
//
//public class SimpleProducer {
//
//    public SimpleProducer() {
//        Properties properties = new Properties();
//        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.KAFKA_BROKER);
//        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Serializable.class.getName());
//        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Serializable.class.getName());
//
//    }
//}
