public class Worker implements Runnable {
    CountDownLatch latch = null;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        // do some job

        // when ready release latch
        latch.countDown();

        System.out.println("Latch Released");
    }
}