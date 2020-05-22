public class AsyncResult<V> implements ListenableFuture<V> {
    // ...

    public AsyncResult(@Nullable V value) {
        this(value, null);
    }

    private AsyncResult(@Nullable V value, @Nullable Throwable ex) {
        this.value = value;
        this.executionException = ex;
    }

    // Missing empty constructor to comply with Jackson requirements:
    public AsyncResult() {}

// ...