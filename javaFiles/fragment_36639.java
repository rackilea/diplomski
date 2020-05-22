class MyForkJoinWorkerThread extends ForkJoinWorkerThread
{
    MyForkJoinWorkerThread(ForkJoinPool pool)
    {
        super(pool);
        // Change thread name after ForkJoinPool.registerWorker() does the same
        setName("DETERMINISTIC_WORKER");
    }
}

ForkJoinWorkerThreadFactory factory = new ForkJoinWorkerThreadFactory()
{
    private WeakReference<Thread> currentWorker = new WeakReference<>(null);

    @Override
    public synchronized ForkJoinWorkerThread newThread(ForkJoinPool pool)
    {
        // If the pool already has a live thread, wait for it to shut down.
        Thread thread = currentWorker.get();
        if (thread != null && thread.isAlive())
        {
            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {
                log.error("", e);
            }
        }
        ForkJoinWorkerThread result = new MyForkJoinWorkerThread(pool);
        currentWorker = new WeakReference<>(result);
        return result;
    }
};