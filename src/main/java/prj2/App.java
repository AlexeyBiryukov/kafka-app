//package prj2;
//
//import java.util.Arrays;
//import java.util.concurrent.ExecutionException;
//
//public class App {
//    public static void main(String args[]) throws InterruptedException, ExecutionException {
//        JavaKafkaProducer producer = new JavaKafkaProducer();
//        JavaKafkaConsumer consumer = new JavaKafkaConsumer();
//
//        String bootstratServer = "localhost:9092";
//        String consumerGroup = "myFirstConsumerGroup";
//        String topic = "myFirstTopic";
//
//        Thread t1 = new Thread() {
//            public void run() {
//                consumer.start(bootstratServer, consumerGroup, Arrays.asList(topic));
//            }
//        };
//
//        Thread t2 = new Thread() {
//            public void run() {
//                try {
//                    producer.start(bootstratServer, topic);
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        t1.start();
//        t2.start();
//
//    }
//}