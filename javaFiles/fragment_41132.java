import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Task t = new Task();
        Future<String> future = executor.submit(t);

        try {
            System.out.println("Started..");
            System.out.println(future.get(5, TimeUnit.SECONDS)); // throws
                                                                    // TimeoutException
            System.out.println("Finished!");
        } catch (TimeoutException e) {
            future.cancel(true);
            System.out.println("Terminated!");
        }
    }
}

class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000);
            System.out.println("task running!");
        }
        return "Ready!";
    }
}