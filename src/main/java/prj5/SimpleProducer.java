package prj5;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SimpleProducer {

    public static void main(String[] args) throws Exception{
        // Проверяем длинну массива.
        if (args.length == 0) {
            System.out.println("Enter topic name");
            return;
        }
        // Задаем имя топику,строковой переменной.
        String topicName = args[0].toString();
        // ???
        Properties properties = new Properties();
        //список брокеров / адрес.
        properties.put("boostrap.server", "localhost:9092");
        //Установите подтверждения для запросов производителя.
        properties.put("acks", "all");
        //Если запрос не выполняется,
        //производитель может автоматически повторить попытку.
        properties.put("retries", 0);
        // ключ для интерфейса
        properties.put("key.serializer",
                "org.apache.kafka.common.serializa-tion.StringSerializer");
        // значение для интерфейса
        properties.put("value.serializer",
                "org.apache.kafka.common.serializa-tion.StringSerializer");
        //
        Producer<String, String> producer = new KafkaProducer
                <String, String>(properties);
        // цикл
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>(topicName, Integer.toString(i), Integer.toString(i)));
            System.out.println("Message sent successfully");
            producer.close();
        }
    }
}
