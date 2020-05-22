private abstract static class Cache<T> {
    private final AtomicReference<CompletableFuture<ImmutableList<T>>> value = 
        new AtomicReference<>();
    private static final int MAX_TRIES = 5;

    protected abstract ImmutableList<T> getUpdate();

    public void clear() {
        value.getAndUpdate(f -> f != null && f.isDone() ? null : f);
        // or value.set(null); if you want the cache to be invalidated while it is being updated.
    }

    public ImmutableList<T> get() {
        CompletableFuture<ImmutableList<T>> f = value.get();
        if (f != null) {
            try {
                return f.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        f = new CompletableFuture<>();
        if (!value.compareAndSet(null, f)) {
            return get();
        }
        for(int tries = 0; ; ){
            try {
                ImmutableList<T> update = getUpdate();
                f.complete(update);
                return update;
            } catch (Exception e){
                if(++tries == MAX_TRIES){
                    f.completeExceptionally(e);
                    throw new RuntimeException(e);
                }
            }
        }
    }
}