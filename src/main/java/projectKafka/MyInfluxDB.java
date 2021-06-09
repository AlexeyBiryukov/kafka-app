package projectKafka;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Pong;
import org.slf4j.Logger;

public class MyInfluxDB {
    final String serverUrl = "http://localhost:8086", username = "Mydb", password = "java";
    final InfluxDB influxDB = InfluxDBFactory.connect(serverUrl, username, password);
    private Logger log;

    public static void main(String[] args) {
        MyInfluxDB myInfluxDB = new MyInfluxDB();
    }
    public void MyInfluxDB() {
        Pong response = this.influxDB.ping();
            if (response.getVersion().equalsIgnoreCase("unknown")) {
                log.error("Error pinging server.");
            return;
        }
        influxDB.createRetentionPolicy("defaultPolicy", "Mydb", "30d", 1, true);
        influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
    }
}

