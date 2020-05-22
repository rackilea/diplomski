import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class Worker implements Runnable {

    private final AtomicInteger sum;
    private final CountDownLatch latch;

    public Worker(AtomicInteger sum, CountDownLatch latch) {
        this.sum = sum;
        this.latch = latch;
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            // Sleep a random length of time from 5-10s
            Thread.sleep(random.nextInt(5000) + 5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Compute x
        int x = random.nextInt(500);

        // Add to the shared sum
        System.out.println("Adding " + x + " to sum");
        sum.addAndGet(x);

        // This runnable is finished, so count down
        latch.countDown();
    }
}

class Program {

    public static void main(String[] args) {
        // There will be 39 workers
        final int N = 39;

        // Holds the sum of all results from all workers
        AtomicInteger sum = new AtomicInteger();
        // Tracks how many workers are still working
        CountDownLatch latch = new CountDownLatch(N);

        System.out.println("Starting " + N + " workers");

        for (int i = 0; i < N; i++) {
            // Each worker uses the shared atomic sum and countdown latch.
            Worker worker = new Worker(sum, latch);

            // Start the worker
            new Thread(worker).start();
        }

        try {
            // Important: waits for all workers to finish.
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Compute the average
        double average = (double) sum.get() / (double) N;

        System.out.println("    Sum: " + sum.get());
        System.out.println("Workers: " + N);
        System.out.println("Average: " + average);
    }

}