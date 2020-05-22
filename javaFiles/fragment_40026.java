import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WaitableThreadPoolExecutor extends ThreadPoolExecutor
{
    private Condition waitCondition;
    private ReentrantLock lock;
    private int taskCount = 0;

    public WaitableThreadPoolExecutor( int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue )
    {
        super( corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue );

        lock = new ReentrantLock( );
        waitCondition = lock.newCondition( );
    }

    // if isEmpty() is true, then there is no need to block
    // otherwise, wait until waitCondition is signaled
    public void waitUntilFinished( )
    {
        lock.lock( );
        try
        {
            while ( !isEmpty( ) )
                waitCondition.await( );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock( );
        }
    }

    // the ThreadPool is empty if our taskCount is 0 and the
    // work queue is empty (this may not be bullet-proof, for one
    // thing, I'm hesitant to use getActiveCount() because it
    // does not guarantee an exact answer
    protected boolean isEmpty( )
    {
        lock.lock( );
        try
        {
            return taskCount == 0 && getQueue( ).isEmpty( );
        }
        finally
        {
            lock.unlock( );
        }
    }

    // increment our task count before executing each task
    @Override
    protected void beforeExecute( Thread t, Runnable r )
    {
        super.beforeExecute( t, r );

        lock.lock( );
        try
        {
            taskCount += 1;
        }
        finally
        {
            lock.unlock( );
        }
    }

    // decrement our task count after executing each task
    // then, if the pool is empty, signal anyone waiting
    // on the waitCondition
    @Override
    protected void afterExecute( Runnable r, Throwable t )
    {
        super.afterExecute( r, t );

        lock.lock( );
        try
        {
            taskCount -= 1;

            if ( isEmpty( ) ) waitCondition.signalAll( );
        }
        finally
        {
            lock.unlock( );
        }
    }

    public static void main( String[] args )
    {
        WaitableThreadPoolExecutor pool = new WaitableThreadPoolExecutor( 2, 4, 5000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>( ) );

        for ( int i = 0 ; i < 10 ; i++ )
        {
            final int threadId = i;

            pool.execute( new Runnable( )
            {
                @Override
                public void run( )
                {
                    try { Thread.sleep( (int) ( Math.random( ) * 5000 ) ); } catch ( InterruptedException e ) { }

                    System.out.println( threadId + " done." );
                }
            });
        }

        pool.waitUntilFinished( );

        System.out.println( "Done waiting." );
    }
}