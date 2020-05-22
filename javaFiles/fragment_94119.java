class BarrierThread extends Thread {
    private final CyclicBarrier cyclicBarrier;
    public BarrierThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        try {
            System.out.println(getName() + ": Started");
            if (this.cyclicBarrier != null) this.cyclicBarrier.await();
            System.out.println(getName() + ": Phase 1");
            if (this.cyclicBarrier != null) this.cyclicBarrier.await();
            System.out.println(getName() + ": Phase 2");
            if (this.cyclicBarrier != null) this.cyclicBarrier.await();
            System.out.println(getName() + ": Done");
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println(getName() + ": " + e);
        }
    }
}