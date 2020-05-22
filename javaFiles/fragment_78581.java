import com.google.appengine.api.ThreadManager;

...

final long tScheduleDelay = 5000;
ThreadManager.createThreadForCurrentRequest( new Runnable()
{
    @Override
    public void run()
    {
        try
        {
            Thread.sleep( tScheduleDelay );
        }
        catch ( InterruptedException ex )
        {
            // log possible exception
        }

        // Objectify query here.
    }
} ).start();