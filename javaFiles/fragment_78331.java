private static final ThreadFactory THREAD_FACTORY = new ThreadFactory()
{
    private final ThreadFactory factory = Executors.defaultThreadFactory();

    @Override
    public Thread newThread(final Runnable r)
    {
        final Thread ret = factory.newThread(r);
        ret.setDaemon(true);
        return ret;
    }
};

// ...
private final ScheduledExecutorService service
    = Executors.newSingleThreadScheduledExecutor(THREAD_FACTORY);

//...
service.scheduleAtFixedRate(etc etc);