class CachingSupplier<T> implements Supplier<T> {
    private final Supplier<? extends T> delegate;
    private final ConcurrentHashMap<Supplier<? extends T>,T> map=new ConcurrentHashMap<>();

    CachingSupplier(Supplier<? extends T> delegate) {
        this.delegate = Objects.requireNonNull(delegate);;
    }

    @Override
    public T get() {
        return map.computeIfAbsent(delegate, Supplier::get);
    }
}