// Two threads running so count down from 2.
CountDownLatch wait = new CountDownLatch(2);

class TestRun implements Runnable {

    private final long waitTime;

    public TestRun(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        try {
            // Wait a few seconds.
            Thread.sleep(waitTime);
            // Finished! Count me down.
            wait.countDown();
            System.out.println(new Date() + ": " + Thread.currentThread().getName() + " - Finished");
        } catch (InterruptedException ex) {
            System.out.println(Thread.currentThread().getName() + " - Interrupted");
        }
    }

}

public void test() throws InterruptedException {
    // ThreadA
    Thread threadA = new Thread(new TestRun(10000), "Thread A");
    // ThreadB
    Thread threadB = new Thread(new TestRun(30000), "Thread B");
    // Fire them up.
    threadA.start();
    threadB.start();
    // Wait for all to finish but threadA must finish.
    threadA.join();
    // Wait up to 3 seconds for B.
    wait.await(3, TimeUnit.SECONDS);
    System.out.println(new Date() + ": Done");
    threadB.join();
}