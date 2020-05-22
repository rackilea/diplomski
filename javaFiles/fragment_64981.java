public class ExecutorTest
{
    private static final int CORE_POOL_SIZE = 2;
    private static final int MAXIMUM_POOL_SIZE = 4;
    private static final int KEEP_ALIVE_TIME_MS = 5000;

    public static void main(String[] args)
    {
        final SaturateExecutorBlockingQueue workQueue = 
            new SaturateExecutorBlockingQueue();

        final ThreadPoolExecutor executor = 
            new ThreadPoolExecutor(CORE_POOL_SIZE, 
                    MAXIMUM_POOL_SIZE, 
                    KEEP_ALIVE_TIME_MS, 
                    TimeUnit.MILLISECONDS, 
                    workQueue);

        workQueue.setExecutor(executor);

        for (int i = 0; i < 6; i++)
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
                            + " on thread: " + Thread.currentThread());
                }
            });
        }
    }

    public static class SaturateExecutorBlockingQueue 
        extends LinkedBlockingQueue<Runnable>
    {
        private ThreadPoolExecutor executor;

        public void setExecutor(ThreadPoolExecutor executor)
        {
            this.executor = executor;
        }

        public boolean offer(Runnable e)
        {
            if (executor.getPoolSize() < executor.getMaximumPoolSize())
            {
                return false;
            }
            return super.offer(e);
        }
    }
}