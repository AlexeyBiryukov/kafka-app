package projectKafka;

import com.sun.net.httpserver.HttpServer;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Pong;
import java.net.InetSocketAddress;

public class MyInfluxDB {
    final String serverUrl = "http://127.0.0.1:8086",  username = "root", password = "root";
    final InfluxDB influxDB= InfluxDBFactory.connect(serverUrl, username, password);

    public void setInfluxDB() {
        Pong response = this.influxDB.ping();
        if (response.getVersion().equalsIgnoreCase("unknown")) {
            System.out.println("error pinging server.");
            return;
        }
        influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
    }
}