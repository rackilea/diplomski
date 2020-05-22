public class ThreadPoolExecutorFactory implements FactoryBean 
{
    private final ReentrantLock lock = new ReentrantLock();   
    private ThreadPoolExecutor executor;
    private int corePoolSize;
    private int maximumPoolSize;
    private long keepAliveTime;
    private TimeUnit unit;

    public Object getObject() 
    {
        lock.lock();
        if (executor == null)
            executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                    keepAliveTime, unit, new LinkedBlockingQueue<Runnable>());
        lock.unlock();
        return executor;
    }

    public Class getObjectType() 
    {
        return ThreadPoolExecutor.class;
    }

    public boolean isSingleton()    
    {
        return true;
    }
}