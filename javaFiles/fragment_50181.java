import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
...
final int NUM_THREADS = ...;
final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
...
executorService.submit(new Runnable() {
    @Override
    public void run() {
        foo();
    }
});