import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierUsage {

    private static final int NUMBER_OF_THREADS = 2;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(NUMBER_OF_THREADS);

        Thread t1 = new Thread(new PrimaryParty(barrier));
        Thread t2 = new Thread(new PrimaryParty(barrier));

        t1.start();
        t2.start();    
    }
}

class PrimaryParty implements Runnable {

    private CyclicBarrier barrier;

    public PrimaryParty(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        //Statement 1
        //Statement 2
        //Statement 3

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        //Statement 4
    }
}