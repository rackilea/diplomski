import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

class Worker implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random random = new Random();

        // Sleep a random length of time, from 5-10s
        Thread.sleep(random.nextInt(5000) + 5000);

        // Compute x
        int x = random.nextInt(500);
        System.out.println("Computed " + x);

        return x;
    }

}

public class Program {

    public static void main(String[] args) {
        // Thread pool size
        final int POOL_SIZE = 10;

        // There will be 39 workers
        final int N = 39;

        System.out.println("Starting " + N + " workers");

        // Create the workers
        Collection<Callable<Integer>> workers = new ArrayList<Callable<Integer>>(N);

        for (int i = 0; i < N; i++) {
            workers.add(new Worker());
        }

        // Create the executor service
        ExecutorService executor = new ScheduledThreadPoolExecutor(POOL_SIZE);

        // Execute all the workers, wait for the results
        List<Future<Integer>> results = null;

        try {
            // Executes all tasks and waits for them to finish
            results = executor.invokeAll(workers);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        // Compute the sum from the results
        int sum = 0;

        for (Future<Integer> future : results) {
            try {
                sum += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace(); return;
            } catch (ExecutionException e) {
                e.printStackTrace(); return;
            }
        }

        // Compute the average
        double average = (double) sum / (double) N;

        System.out.println("         Sum: " + sum);
        System.out.println("     Workers: " + N);
        System.out.println("     Average: " + average);
    }

}