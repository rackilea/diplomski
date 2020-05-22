public class ExecutorTest2
{
    private static final int KEEP_ALIVE_TIME_MS = 5000;
    private static final int CORE_POOL_SIZE = 2;
    private static final int MAXIMUM_POOL_SIZE = 4;

    public static void main(String[] args) throws InterruptedException
    {
        final SaturateExecutorBlockingQueue workQueue = 
            new SaturateExecutorBlockingQueue(CORE_POOL_SIZE, 
                    MAXIMUM_POOL_SIZE);

        final ThreadPoolExecutor executor = 
            new ThreadPoolExecutor(CORE_POOL_SIZE, 
                    MAXIMUM_POOL_SIZE, 
                    KEEP_ALIVE_TIME_MS, 
                    TimeUnit.MILLISECONDS, 
                    workQueue);

        workQueue.setExecutor(executor);

        for (int i = 0; i < 60; i++)
        {
            final int index = i;
            executor.submit(new Runnable()
            {
                public void run()
                {
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                    System.out.println("Runnable " + index 
                            + " on thread: " + Thread.currentThread()
                            + " poolSize: " + executor.getPoolSize());
                }
            });
        }

        executor.shutdown();

        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    public static class SaturateExecutorBlockingQueue 
        extends LinkedBlockingQueue<Runnable>
    {
        private final int corePoolSize;
        private final int maximumPoolSize;
        private ThreadPoolExecutor executor;

        public SaturateExecutorBlockingQueue(int corePoolSize, 
                int maximumPoolSize)
        {
            this.corePoolSize = corePoolSize;
            this.maximumPoolSize = maximumPoolSize;
        }

        public void setExecutor(ThreadPoolExecutor executor)
        {
            this.executor = executor;
        }

        public boolean offer(Runnable e)
        {
            if (super.offer(e) == false)
            {
                return false;
            }
            // Uncomment one or both of the below lines to increase
            // the likelyhood of the threadpool reusing an existing thread 
            // vs. spawning a new one.
            //Thread.yield();
            //Thread.sleep(0);
            int currentPoolSize = executor.getPoolSize();
            if (currentPoolSize < maximumPoolSize 
                    && currentPoolSize >= corePoolSize)
            {
                executor.setCorePoolSize(currentPoolSize + 1);
                executor.setCorePoolSize(corePoolSize);
            }
            return true;
        }
    }
}