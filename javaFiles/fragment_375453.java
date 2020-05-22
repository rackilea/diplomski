import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class BarrierCalc implements Runnable {

public static final int CALC_THREADS = 3;

private static final AtomicBoolean runCondition = new AtomicBoolean();
private static final AtomicBoolean stopRunning = new AtomicBoolean();

public static void main(String[] args) {

    CyclicBarrier barrier = new CyclicBarrier(CALC_THREADS + 1);
    for (int i = 0; i < CALC_THREADS; i++) {
         new Thread(new BarrierCalc(barrier)).start();
    }
    try {
        runCondition.set(true);
        barrier.await();
        showln(0, "STATS!");

        barrier.await();
        showln(0, "start looping 1");
        Thread.sleep(200);
        runCondition.set(false);
        showln(0, "stop looping 1");
        barrier.await();
        runCondition.set(true);

        barrier.await();
        showln(0, "start looping 2");
        Thread.sleep(100);
        runCondition.set(false);
        showln(0, "stop looping 2");
        barrier.await();

        stopRunning.set(true);
        showln(0, "finishing");
        barrier.await();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private static final AtomicInteger calcId = new AtomicInteger();

private CyclicBarrier barrier;
private int id;

public BarrierCalc(CyclicBarrier barrier) {
    this.barrier = barrier;
    id = calcId.incrementAndGet();
}

public void run() {

    showln(id, "waiting for start");
    try {
        barrier.await(); // display stats
        barrier.await(); // start running
        int loopNumber = 0;
        while (!stopRunning.get()) {
            showln(id, "looping " + (++loopNumber));
            while (runCondition.get()) {
                Thread.sleep(10); // simulate looping
            }
            showln(id, "synchronizing " + loopNumber);
            barrier.await();
            showln(id, "synchronized " + loopNumber);
            // give main thread a chance to set stopCondition and runCondition
            barrier.await();
        }
        showln(id, "finished");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private static final long START_TIME = System.currentTimeMillis();

public static void showln(int id, String msg) {
    System.out.println((System.currentTimeMillis() - START_TIME) + "\t ID " + id + ": " + msg);
}

}