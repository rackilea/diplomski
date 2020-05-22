public class Test {
    final int counter = 0; // it may be a different number
    final CyclicBarrier barrier = new CyclicBarrier(counter);

    public void testSync() throws InterruptedException, BrokenBarrierException {
        barrier.await();
    }
}