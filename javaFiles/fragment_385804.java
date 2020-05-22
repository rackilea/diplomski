class CachingSupplier<T> implements Supplier<T> {
    private final List<Supplier<? extends T>> delegate;
    private boolean initialized;

    CachingSupplier(Supplier<? extends T> delegate) {
        Objects.requireNonNull(delegate);
        this.delegate = Arrays.asList(() -> {
            synchronized(this) {
                if(!initialized) {
                    T value = delegate.get();
                    setSupplier(() -> value);
                    initialized = true;
                    return value;
                }
                return getSupplier().get();
            }
        });
    }
    private void setSupplier(Supplier<? extends T> s) {
        delegate.set(0, s);
    }
    private Supplier<? extends T> getSupplier() {
        return delegate.get(0);
    }

    @Override
    public T get() {
        return getSupplier().get();
    }
}