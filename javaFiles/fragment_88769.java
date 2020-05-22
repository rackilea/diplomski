class CachingSupplier<T> implements Supplier<T> {

    private T cachedValue;
    private Supplier<T> originalSupplier;

    public CachingSupplier(Supplier<T> originalSupplier) {
        this.originalSupplier = originalSupplier;
    }

    @Override
    public T get() {
        if (cachedValue == null) {
            cachedValue = originalSupplier.get();
        }
        return cachedValue;
    }
}

public static <T> Supplier<T> memoize(final Supplier<? extends T> valueSupplier) {
  return new CachingSupplier<>(valueSupplier);
}