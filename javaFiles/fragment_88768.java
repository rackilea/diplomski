class CachingSupplier<T> implements Supplier<T> {

    final List<T> memoryList= new ArrayList<>();
    private Supplier<T> originalSupplier;

    public CachingSupplier(Supplier<T> originalSupplier) {
        this.originalSupplier = originalSupplier;
    }

    @Override
    public T get() {
        if (memoryList.isEmpty()) {
            memoryList.add(originalSupplier.get());
        }
        return memoryList.get(0);
    }
}

public static <T> Supplier<T> memoize(final Supplier<? extends T> valueSupplier) {
  return new CachingSupplier<>(valueSupplier);
}