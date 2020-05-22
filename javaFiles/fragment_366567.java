public class Task implements Runnable
{
    private ReentrantLock lock;
    private ExecutorService executor;

    public Task(ExecutorService executor)
    {
        this.executor=executor;
    }

    @Override
    public void run()
    {

        //do some stuff
        //...

        lock.lock();
        executor.execute(this);
        lock.unlock();
    }
}