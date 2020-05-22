final Lock lock = new ReentrantLock();

....

void attemptJob( Runnable runnable )
{
    if (!lock.tryLock())
        throw new ConcurrentJobException();

    try
    {
       runnable.run();
    }
    finally
    {
       lock.unlock();
    }
}