class CachingSupplier<T> implements Supplier<T> {
    private Supplier<? extends T> delegate;
    private boolean initialized;

    CachingSupplier(Supplier<? extends T> delegate) {
        Objects.requireNonNull(delegate);
        this.delegate = () -> {
            synchronized(this) {
                if(!initialized) {
                    T value = delegate.get();
                    this.delegate = () -> value;
                    initialized = true;
                    return value;
                }
                return this.delegate.get();
            }
        };
    }

    @Override
    public T get() {
        return this.delegate.get();
    }
}