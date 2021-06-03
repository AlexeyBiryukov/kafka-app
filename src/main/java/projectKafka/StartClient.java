package projectKafka;

public class StartClient {
    public static void main(String[] args) throws InterruptedException {
        Client start = new Client();

        Thread t1 = new Thread() {
            public void run() {
                start.StartResponse();
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
                    start.StartRequest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t2.start();
    }
}
