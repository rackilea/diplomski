final Lock lock = new ReentrantLock();
final ExecutorService service = Executors.newSingleThreadExecutor();

....

void attemptJob( final Runnable runnable )
{
    if (!lock.tryLock())
        throw new ConcurrentJobException();

    service.execute( new Runnable()
    {
        public void run()
        {
            try
            {
                runnable.run();
            }
            finally
            {
                lock.unlock();
            } 
        }
    });
}