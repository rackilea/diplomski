import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Example {

    public static void main(String[] args) throws InterruptedException {
        ScheduledFuture future = Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new MyScheduledTask(), 0, 10, TimeUnit.SECONDS);
        ExecutorService executor = Executors.newFixedThreadPool(3); // pool composed of 3 threads
        for (int i = 0; i < 3; i++) {
            // for the example assuming that the 3 threads execute the same task.
            executor.execute(new AnyTask()); 
        }
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // expect current thread to wait for the ending of the 3 threads
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.TimeUnit.NANOSECONDS); 
        future.cancel(false); // to exit properly the scheduled task
        // reprocessing the scheduled task only one time as expected
        new Thread(new ScheduledTask()).start(); 

    }


}

class MyScheduledTask implements Runnable {
    @Override
    public void run() {
        //Process scheduled task here
    }
}

class AnyTask implements Runnable {
    @Override
    public void run() {
        //Process job of threads here
    }
}