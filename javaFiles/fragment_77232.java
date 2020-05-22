import java.util.concurrent.CountDownLatch;

public class Main {


    static class Child implements Runnable {

        CountDownLatch waitLatch;
        CountDownLatch notifyLatch;

        public Child(CountDownLatch waitLatch, CountDownLatch notifyLatch) {
            this.waitLatch = waitLatch;
            this.notifyLatch = notifyLatch;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("abc");
                if (i == 5) {
                    try {
                        notifyLatch.countDown(); // signal main thread, let it print number 5
                        waitLatch.await(); // wait for the signal from main thread
                    } catch (InterruptedException e) {

                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        CountDownLatch waitLatch = new CountDownLatch(1);
        CountDownLatch notifyLatch = new CountDownLatch(1);

        Runnable child = new Child(waitLatch, notifyLatch);
        new Thread(child).start();

        try {
            notifyLatch.await(); // wait for the signal from child thread
        } catch (InterruptedException ignore) {

        }
        System.out.println(5);
        waitLatch.countDown(); // resume child thread
    }
}