public class CriticalThread extends Thread {

    private final CriticalMonitor monitor;
    private int threadId;
    private CyclicBarrier barrier;

    public CriticalThread(CriticalMonitor m, int id, CyclicBarrier barrier) {
        monitor = m;
        monitor.N++;
        threadId = id;
        this.barrier = barrier;
    }

    public void run() {
        monitor.uncritical(threadId);
        //random number of calls to critical()?
        try {
            barrier.await();
            int rand = (int) (Math.random() * 5);
            int time = 0;
            int limit = 5;
            while (time < limit) {
                if (rand > 0) {
                    monitor.critical(threadId);
                    rand--;
                }
                barrier.await();
                time++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}