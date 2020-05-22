import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaMonoTest {

    static final AtomicInteger threadCount = new AtomicInteger();
    static final AtomicInteger completeCount = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        final int numberOfCycles = 1000;
        final int numbersPerCycle = 1000000;
        final int NUM_CORES = Runtime.getRuntime().availableProcessors();

        long swG = System.nanoTime();

        ExecutorService exec = Executors.newFixedThreadPool(NUM_CORES);
        try {
            for (int i = 0; i < numberOfCycles; i++) {
                final int x = i;
                exec.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                        System.out.printf("Starting cycle %s. Thread count at %s %n", x, threadCount.getAndIncrement());

                        Random r = new Random();
                        long sw = System.nanoTime();
                        double[] numbers = new double[numbersPerCycle];
                        for (int i = 0; i < numbersPerCycle; i++) {
                            numbers[i] = r.nextDouble() * 1000;
                        }
                        Arrays.sort(numbers);
                        double min = numbers[0];
                        double max = numbers[numbers.length - 1];

                        completeCount.getAndIncrement();
                        System.out.printf("%s cycles complete: %.2f ms. Min: %.2f  Max: %.2f %n",
                                completeCount, (System.nanoTime() - sw) / 1e6, min, max);
                        threadCount.getAndDecrement();
                        } catch (Throwable t) {
                            t.printStackTrace();
                        }
                    }
                });
            }
        } finally {
            exec.shutdown();
        }
        exec.awaitTermination(1, TimeUnit.DAYS);

        System.out.printf("All %s cycles complete. Took %.2f ms. %n",
                numberOfCycles, (System.nanoTime() - swG) / 1e6);
    }
}