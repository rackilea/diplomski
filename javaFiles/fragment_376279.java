import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class MainThread
{
        public static void main(String[] args)
        {
                int corePoolSize = 2;
                ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(corePoolSize);

                /*
                 * This will execute the WorkerThread immediately
                 */
                stpe.execute(new WorkerThread("WorkerThread-Running-Immediately"));

                /*
                 * This will execute the WorkerThread only once after 10 Seconds
                 */
                stpe.schedule(new WorkerThread("WorkerThread-Scheduled-After-10-seconds"), 10, TimeUnit.SECONDS);

                /*
                 * This will execute the WorkerThread continuously for every 5 seconds with an initial delay of 10
                 * seconds for the first WorkerThread to start execution cycle. In this case, whether the first
                 * WorkerThread is completed or not, the second WorkerThread will start exactly after 5 seconds hence
                 * called schedule at fixed rate. This continues till 'n' threads are executed.
                 */
                stpe.scheduleAtFixedRate(new WorkerThread("WorkerThread-Running-At-Fixed-Rate"), 10, 5, TimeUnit.SECONDS);

                /*
                 * This will execute the WorkerThread continuously with an initial delay of 10 seconds for the first
                 * WorkerThread to start execution cycle. Once the first thread execution completes then a delay of 5
                 * Seconds is introduced so that the next WorkerThread execution cycle starts. This continues till
                 * 'n' thread are executed. This is called schedule each thread with a fixed delay.
                 */
                stpe.scheduleWithFixedDelay(new WorkerThread("WorkerThread-Running-With-Fixed-Delay"), 10, 5, TimeUnit.SECONDS);
        }
}