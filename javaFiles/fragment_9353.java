import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ThreadTask implements Runnable {

    private int total = 0;

    public ThreadTask(int total) {
        this.total = total;
    }

    @Override
    public void run() {
        int value = 0;
        for(int i = 0; i < total; i++) {
            value = i * i;
        }
    }       
}

public class Test {

    public static void main(String[] args) throws InterruptedException {

        int total = 1000000000;

        long start = System.currentTimeMillis();
        long value = 0;
        for(int i = 0; i < total; i++) {
            value = i * i;
        }       
        long stop = System.currentTimeMillis();

        System.out.println((stop - start) + " ms");

        ExecutorService exec = Executors.newFixedThreadPool(4);
        start = System.currentTimeMillis();
        for(int i = 0; i < 4; i++) {
            exec.submit(new ThreadTask(total / 4));
        }
        exec.shutdown();
        exec.awaitTermination(10, TimeUnit.SECONDS);
        stop = System.currentTimeMillis();

        System.out.println((stop - start) + " ms");     
    }
}