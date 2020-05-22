package tests;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Stream;

public class Test implements Runnable {
    static final int n_threads = 8;
    static final long LOOPS = 10000;
    public static int global_counter;
    public static CyclicBarrier thread_barrier = new CyclicBarrier(n_threads + 1);

    public volatile int local_counter;

    @Override
    public void run() {
        try {
            runImpl();
        } catch (InterruptedException | BrokenBarrierException e) {
            //
        }
    }

    void runImpl() throws InterruptedException, BrokenBarrierException {
        for (int i = 0; i < LOOPS; i++) {
            thread_barrier.await();
            local_counter = 0;
            for (int j=0; j<20; j++)
                local_counter++;
            thread_barrier.await();
        }
    }

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Test[] ra = new Test[n_threads];
        Thread[] ta = new Thread[n_threads];
        for(int i=0; i<n_threads; i++)
            (ta[i] = new Thread(ra[i]=new Test()).start();

        long nanos = System.nanoTime();
        for (int i = 0; i < LOOPS; i++) {
            thread_barrier.await();
            thread_barrier.await();

            for (int t=0; t<ra.length; t++) {
                global_counter += ra[t].local_counter;
            }
        }

        System.out.println(global_counter+", "+1e-6*(System.nanoTime()-nanos)+" ms");

        Stream.of(ta).forEach(t -> t.interrupt());
    }
}