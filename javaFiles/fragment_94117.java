class LatchThread extends Thread {
    private final CountDownLatch countDownLatch;
    public LatchThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            System.out.println(getName() + ": Started");
            this.countDownLatch.countDown();
            this.countDownLatch.await();
            System.out.println(getName() + ": Done");
        } catch (InterruptedException e) {
            System.out.println(getName() + ": " + e);
        }
    }
}