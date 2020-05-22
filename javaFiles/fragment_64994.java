class ListSupplier<T> implements Supplier<T> {
  private final AtomicInteger next = new AtomicInteger();
  private final List<T> elements; // ctor injected

  …
  public <T> get() {
    // real impl more complicated due to bounds checks
    // and what to do when exhausted
    return elements.get(next.getAndIncrement());
  }
}