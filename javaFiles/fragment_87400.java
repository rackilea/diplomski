public class CountUpAndDownLatch {
    private CountDownLatch latch;
    private final Object lock = new Object();

    public CountUpAndDownLatch(int count) {
        this.latch = new CountDownLatch(count);
    }

    public void countDownOrWaitIfZero() throws InterruptedException {
        synchronized(lock) {
            while(latch.getCount() == 0) {
                lock.wait();
            }
            latch.countDown();
            lock.notifyAll();
        }
    }

    public void waitUntilZero() throws InterruptedException {
        synchronized(lock) {
            while(latch.getCount() != 0) {
                lock.wait();
            }
        }
    }

    public void countUp() { //should probably check for Integer.MAX_VALUE
        synchronized(lock) {
            latch = new CountDownLatch((int) latch.getCount() + 1);
            lock.notifyAll();
        }
    }

    public int getCount() {
        synchronized(lock) {
            return (int) latch.getCount();
        }
    }
}