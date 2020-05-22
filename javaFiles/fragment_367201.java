public class LatchSample {

    private final CountDownLatch latch = new CountDownLatch(1);

    public void doSomething() {
        // do something
        // signal completion after you did what you had to do
        latch.countDown();
    }

    public void doSomethingAfterCompletion() {
        // will block until countDown() is called
        latch.await();
    }
}