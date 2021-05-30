package prj4;

public interface IKafkaConstants {
    public static String KAFKA_BROKER = "localhost:9092";

    public static Integer MESSAGE_COUNT = 1000;

    public static String CLIENT_ID = "client_1";

    public static String TOPIC_NAME = "channel_1";

    public String GROUP_ID_CONFIG = "comsumer_Group_1";

    public static Integer MAX_NO_MESSAGE_FOUND_COUNT = 100;
}
