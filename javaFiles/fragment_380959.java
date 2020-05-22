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
            // Record that I've finished.
            finished();
        } catch (InterruptedException ex) {
            System.out.println(Thread.currentThread().getName() + " - Interrupted");
        }
    }

}

Runnable cleanup = new Runnable() {

    @Override
    public void run() {
        try {
            // Wait up to 3 seconds for both threads to clear.
            wait.await(3, TimeUnit.SECONDS);
            // Do your cleanup stuff here.
            // ...
            System.out.println(new Date() + ": " + Thread.currentThread().getName() + " - Finished");
        } catch (InterruptedException ex) {
            System.out.println(Thread.currentThread().getName() + " - Interrupted");
        }
    }

};

final AtomicBoolean cleanupStarted = new AtomicBoolean(false);

private void finished() {
    // Make sure I only start the cleanup once.
    if (cleanupStarted.compareAndSet(false, true)) {
        new Thread(cleanup, "Cleanup").start();
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
    System.out.println(new Date() + ": Done");
}