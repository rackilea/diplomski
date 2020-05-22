public class Waiter implements Runnable{
    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            // wait for the latch to be released
            latch.await();
        } catch (InterruptedException e) {
            // set interupt flag
            Thread.currentThread().interrupt();
            // log interrupt
            System.out.println("Interrupted");
        }
        System.out.println("Unblocked");

        doSomething();
    }
}