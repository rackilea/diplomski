/**
 * Overrides shutdown() to run outstanding tasks immediately.
 * 
 * @author Gili Tzabari
 */
public class RunOnShutdownScheduledExecutorService extends AbstractExecutorService
    implements ScheduledExecutorService
{
    private final ScheduledExecutorService delegate;
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
    private final ExecutorService immediateService;
    private final ConcurrentMap<Future<?>, Callable<?>> tasks = Maps.newConcurrentMap();

    /**
     * Creates a new RunOnShutdownScheduledExecutorService.
     * 
     * @param delegate the executor to delegate to
     */
    public RunOnShutdownScheduledExecutorService(ScheduledExecutorService delegate)
    {
        Preconditions.checkNotNull(delegate, "delegate may not be null");

        this.delegate = delegate;
        if (delegate instanceof ScheduledThreadPoolExecutor)
        {
            this.scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) delegate;
            this.immediateService = Executors.newFixedThreadPool(scheduledThreadPoolExecutor.
                getCorePoolSize(), scheduledThreadPoolExecutor.getThreadFactory());
        }
        else
        {
            scheduledThreadPoolExecutor = null;
            this.immediateService = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().
                setNameFormat(RunOnShutdownScheduledExecutorService.class.getName() + "-%d").build());
        }
    }

    @Override
    public boolean isShutdown()
    {
        return delegate.isShutdown();
    }

    @Override
    public boolean isTerminated()
    {
        return delegate.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException
    {
        long before = System.nanoTime();
        if (!delegate.awaitTermination(timeout, unit))
            return false;
        long after = System.nanoTime();
        long timeLeft = timeout - unit.convert(after - before, TimeUnit.NANOSECONDS);
        return immediateService.awaitTermination(timeLeft, unit);
    }

    @Override
    public void execute(Runnable command)
    {
        delegate.execute(command);
    }

    @Override
    public ScheduledFuture<?> schedule(final Runnable command, long delay, TimeUnit unit)
    {
        CleaningRunnable decorated = new CleaningRunnable(command);
        ScheduledFuture<?> future = delegate.schedule(decorated, delay, unit);
        decorated.setFuture(future);
        tasks.put(future, Executors.callable(command));
        return new CleaningScheduledFuture<>(future);
    }

    @Override
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit)
    {
        CallableWithFuture<V> decorated = new CallableWithFuture<>(callable);
        ScheduledFuture<V> future = delegate.schedule(decorated, delay, unit);
        decorated.setFuture(future);
        tasks.put(future, callable);
        return new CleaningScheduledFuture<>(future);
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period,
        TimeUnit unit)
    {
        CleaningRunnable decorated = new CleaningRunnable(command);
        ScheduledFuture<?> future = delegate.scheduleAtFixedRate(decorated, initialDelay, period, unit);
        decorated.setFuture(future);
        tasks.put(future, Executors.callable(command));
        return new CleaningScheduledFuture<>(future);
    }

    @Override
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay,
        TimeUnit unit)
    {
        CleaningRunnable decorated = new CleaningRunnable(command);
        ScheduledFuture<?> future =
            delegate.scheduleWithFixedDelay(decorated, initialDelay, delay, unit);
        decorated.setFuture(future);
        tasks.put(future, Executors.callable(command));
        return new CleaningScheduledFuture<>(future);
    }

    @Override
    public synchronized void shutdown()
    {
        if (delegate.isShutdown())
            return;
        if (scheduledThreadPoolExecutor != null)
        {
            // WORKAROUND: http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=7069418
            //
            // Cancel waiting scheduled tasks, otherwise executor won't shut down
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        }
        delegate.shutdown();
        // Users will not be able to cancel() Futures past this point so we're guaranteed that
        // "tasks" will not be modified.

        final List<Callable<?>> outstandingTasks = Lists.newArrayList();
        for (Map.Entry<Future<?>, Callable<?>> entry: tasks.entrySet())
        {
            Future<?> future = entry.getKey();
            Callable<?> task = entry.getValue();

            if (future.isDone() && future.isCancelled())
            {
                // Task called by the underlying executor, not the user. See CleaningScheduledFuture.
                outstandingTasks.add(task);
            }
        }
        tasks.clear();
        if (outstandingTasks.isEmpty())
        {
            immediateService.shutdown();
            return;
        }

        immediateService.submit(new Callable<Void>()
        {
            @Override
            public Void call() throws Exception
            {
                delegate.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

                // Execute outstanding tasks only after the delegate executor finishes shutting down
                for (Callable<?> task: outstandingTasks)
                    immediateService.submit(task);
                immediateService.shutdown();
                return null;
            }
        });
    }

    @Override
    public List<Runnable> shutdownNow()
    {
        return delegate.shutdownNow();
    }

    /**
     * A Runnable that removes its future when running.
     */
    private class CleaningRunnable implements Runnable
    {
        private final Runnable delegate;
        private Future<?> future;

        /**
         * Creates a new RunnableWithFuture.
         * 
         * @param delegate the Runnable to delegate to
         * @throws NullPointerException if delegate is null
         */
        public CleaningRunnable(Runnable delegate)
        {
            Preconditions.checkNotNull(delegate, "delegate may not be null");

            this.delegate = delegate;
        }

        /**
         * Associates a Future with the runnable.
         * 
         * @param future a future
         */
        public void setFuture(Future<?> future)
        {
            this.future = future;
        }

        @Override
        public void run()
        {
            tasks.remove(future);
            delegate.run();
        }
    }

    /**
     * A Callable that removes its future when running.
     */
    private class CallableWithFuture<V> implements Callable<V>
    {
        private final Callable<V> delegate;
        private Future<V> future;

        /**
         * Creates a new CallableWithFuture.
         * 
         * @param delegate the Callable to delegate to
         * @throws NullPointerException if delegate is null
         */
        public CallableWithFuture(Callable<V> delegate)
        {
            Preconditions.checkNotNull(delegate, "delegate may not be null");

            this.delegate = delegate;
        }

        /**
         * Associates a Future with the runnable.
         * 
         * @param future a future
         */
        public void setFuture(Future<V> future)
        {
            this.future = future;
        }

        @Override
        public V call() throws Exception
        {
            tasks.remove(future);
            return delegate.call();
        }
    }

    /**
     * A ScheduledFuture that removes its future when canceling.
     * 
     * This allows us to differentiate between tasks canceled by the user and the underlying
     * executor. Tasks canceled by the user are removed from "tasks".
     * 
     * @param <V> The result type returned by this Future
     */
    private class CleaningScheduledFuture<V> implements ScheduledFuture<V>
    {
        private final ScheduledFuture<V> delegate;

        /**
         * Creates a new MyScheduledFuture.
         * 
         * @param delegate the future to delegate to
         * @throws NullPointerException if delegate is null
         */
        public CleaningScheduledFuture(ScheduledFuture<V> delegate)
        {
            Preconditions.checkNotNull(delegate, "delegate may not be null");

            this.delegate = delegate;
        }

        @Override
        public long getDelay(TimeUnit unit)
        {
            return delegate.getDelay(unit);
        }

        @Override
        public int compareTo(Delayed o)
        {
            return delegate.compareTo(o);
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning)
        {
            boolean result = delegate.cancel(mayInterruptIfRunning);

            if (result)
            {
                // Tasks canceled by users are removed from "tasks"
                tasks.remove(delegate);
            }
            return result;
        }

        @Override
        public boolean isCancelled()
        {
            return delegate.isCancelled();
        }

        @Override
        public boolean isDone()
        {
            return delegate.isDone();
        }

        @Override
        public V get() throws InterruptedException, ExecutionException
        {
            return delegate.get();
        }

        @Override
        public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException,
            TimeoutException
        {
            return delegate.get(timeout, unit);
        }
    }
}