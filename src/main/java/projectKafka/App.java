package projectKafka;

public class App {
    public static void main(String[] args) {
        Get startGet = new Get();
        Client startClient = new Client();

        Thread t1Get = new Thread() {
            public void run() {
                startGet.StartResponse();
            }
        };

        Thread t2Get = new Thread() {
            public void run() {
                try {
                    startGet.StartRequest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t3Client = new Thread() {
            public void run() {
                startClient.StartResponse();
            }
        };

        Thread t4Client = new Thread() {
            public void run() {
                try {
                    startClient.StartRequest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

    }
}
