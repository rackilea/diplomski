public class TrackingSingleThreadScheduledExecutor
    extends ScheduledThreadPoolExecutor {

  private final DelayQueue<ScheduledFuture<?>> tasks
      = new DelayQueue<RunnableScheduledFuture<?>>();

  public TrackingSingleThreadScheduledExecutor() {
    super(1);
  }

  public DelayQueue<? extends ScheduledFuture<V>> tasks() {
    return tasks;
  }

  public ScheduledFuture<V> next() {
    return tasks.peek();
  }

  protected <V> RunnableScheduledFuture<V> decorateTask
      (final Callable<V> callable, final RunnableScheduledFuture<V> task) {
    return new QueueAwareTask(task);
  }

  protected <V> RunnableScheduledFuture<V> decorateTask
      (final Runnable runnable, final RunnableScheduledFuture<V> task) {
    return new QueueAwareTask(task);
  }

  private final class QueueAwareTask<V> implements RunnableScheduledFuture<V> {

    private final RunnableScheduledFuture<V> inner;

    public QueueAwareTask(final RunnableScheduledFuture<V> inner) {
      this.inner = inner;
    }

    public boolean isPeriodic() {
      return inner.isPeriodic();
    }

    public long getDelay(final TimeUnit unit) {
      return inner.getDelay(unit);
    }

    public void run() {
      inner.run();
      if (queue.remove(inner) && inner.isPeriodic()
          && !inner.isCancelled()) {
        queue.add(inner);
      }
    }

    public int compareTo(final Delayed other) {
      return inner.compareTo(other);
    }

    public boolean cancel(final boolean mayInterruptIfRunning) {
      final boolean cancelled = inner.cancel(mayInterruptIfRunning);
      if (cancelled) {
        queue.remove(inner);
      }
      return cancelled;
    }

    public boolean isCancelled() {
      return inner.isCancelled();
    }

    public boolean isDone() {
      return inner.isDone();
    }

    public V get() throws InterruptedException, ExecutionException {
      return inner.get();
    }

    public V get(final long timeout, final TimeUnit unit)
        throws InterruptedException, ExecutionException {
      return inner.get(timeout, unit);
    }
  }
}