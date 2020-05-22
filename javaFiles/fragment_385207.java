package work.basil.example;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Bogus
{
    public static void main ( String[] args )
    {
        Runnable runnable =
                new Runnable()
                {
                    @Override
                    public void run ( )
                    {
                        try
                        {
                            System.out.println( "Looking up fresh stock prices at " + Instant.now().toString() );
                        }
                        catch ( Exception e )
                        {
                            // … try to recover, if you want the scheduled executor service to continue scheduling this task.
                            // Or, at least, do logging/notifications to know when and why the scheduling of this task halted.
                            e.printStackTrace();
                        }
                    }
                };

        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

        ses.scheduleWithFixedDelay( runnable , 0L , 3L , TimeUnit.SECONDS );

        try
        {
            Thread.sleep( TimeUnit.MINUTES.toMillis( 1 ) );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        finally
        {
            ses.shutdown();  // IMPORTANT Always shutdown gracefully your executor service so the thread pool does not outlive your app.
        }

        System.out.println( "INFO - Completed run at: " + Instant.now() );
    }
}