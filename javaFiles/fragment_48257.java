final class Foo {
  private static final AtomicInteger seed = new AtomicInteger();
  private final int id;

  public Foo() {
    this.id = seed.incrementAndGet();
  }
}