class MyRunnable implements Runnable {
    private CountDownLatch latch;
    MyRunnable (CountDownLatch latch) { this.latch = latch; }
    public void run() {
        doSomeStuff();
        latch.countDown(); // releases the parent thread
        doSomeMoreStuff();
    }
    ...
}