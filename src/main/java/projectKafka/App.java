package projectKafka;

public class App {
    public static void main(String[] args) {
        Get startG = new Get();
        Client startC = new Client();

        Thread t1Get = new Thread() {
            public void run() {
                startG.StartResponse();
            }
        };

        Thread t2Get = new Thread() {
            public void run() {
                try {
                    startG.StartRequest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t3Client = new Thread() {
            public void run() {
                startC.StartResponse();
            }
        };

        Thread t4Client = new Thread() {
            public void run() {
                try {
                    startC.StartRequest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1Get.start();
        t2Get.start();
        t3Client.start();
        t4Client.start();
    }
}
