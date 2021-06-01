package projectGetClass;

public class StartGet {
    public static void main(String[] args) throws InterruptedException {
        Get start = new Get();

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
