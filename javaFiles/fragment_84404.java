import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountToABillion implements Runnable {

    double count = 0;
    ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

    public void echoCount() {
        System.out.println(count);
    }

    @Override
    public void run() {
        Runnable task = new Runnable() {
            public void run() {
                echoCount();
            }
        };
        exec.scheduleAtFixedRate(task, 1, 1, TimeUnit.SECONDS);

        for (double x=0;x<1000000000;x++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            count = x;
        }
        exec.shutdownNow();
    }
}