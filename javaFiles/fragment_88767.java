public static <T> Supplier<T> memoize(final Supplier<? extends T> valueSupplier)
{
    final List<T> memoryList= new ArrayList<>();
    return new Supplier<T>() {
        @Override
        public T get() {
            if (memoryList.isEmpty()) {
                memoryList.add(valueSupplier.get());
            }
            return memoryList.get(0);
        }
    };
}