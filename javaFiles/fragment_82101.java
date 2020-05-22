import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Q21227864 {

public static void main(String[] args) {

    ExecutorService executorService = Executors.newCachedThreadPool();
    Future<?> future = executorService.submit(new MyRunnable());
    sleep(100L);
    future.cancel(true);
    System.out.println("Future done: " + future.isDone());
    sleep(100L);
    future.cancel(true);
    System.out.println("Future done: " + future.isDone());
    sleep(500L);
    System.out.println("Future done: " + future.isDone());

    System.out.println("---");

    MyRunnable mr = new MyRunnable();
    future = executorService.submit(mr);
    sleep(100L);
    future.cancel(true);
    System.out.println("Runnable done: " + mr.isDone());
    sleep(100L);
    System.out.println("Runnable done: " + mr.isDone());
    mr.waitForCleanup();
    System.out.println("Runnable done: " + mr.isDone());

    executorService.shutdownNow();
}

public static void sleep(long timeMs) { 
    try { Thread.sleep(timeMs); } catch (Exception ignored) {}
}

static class MyRunnable implements Runnable {

    final CountDownLatch completed = new CountDownLatch(1);

    public void run() {

        try {
            System.out.println("Sleeping loop");
            Thread.sleep(1000L);
            System.out.println("Sleeping loop done");
        } catch (Exception e) {
            System.out.println("Stopped loop: " + e);
        }
        try {
            System.out.println("Sleeping cleanup");
            Thread.sleep(300L);
            System.out.println("Sleeping cleanup done");
        } catch (Exception e) {
            System.out.println("Stopped cleanup: " + e);
        }
        completed.countDown();
    }

    public boolean isDone() {
        return (completed.getCount() == 0);
    }

    public void waitForCleanup() {
        try { completed.await(); } catch (Exception ignored) {}
    }

}

}