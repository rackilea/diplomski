public class Counter {
    private final CyclicBarrier barrier;
    private int c;

    public Counter(int threads) {
        this.barrier = new CyclicBarrier(threads);
    }

    void await() throws BrokenBarrierException, InterruptedException {
        barrier.await();
    }
    ...
}