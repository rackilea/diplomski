public class FailedFuture<T> implements Future<T> {
    private final Throwable exception;

    public FailedFuture(Throwable exception) {
        this.exception = exception;
    }

    @Override
    public T get() throws ExecutionException {
        throw new ExecutionException(exception);
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws ExecutionException {
        return get();
    }

    @Override public boolean cancel(boolean mayInterruptIfRunning) { return false; }
    @Override public boolean isCancelled() { return false; }
    @Override public boolean isDone() { return true; }
}