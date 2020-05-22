public class BlockingSupplier<E> implements Supplier<E> {
  private final CountDownLatch latch = new CountDownLatch(1);
  private volatile E value;

  public synchronized void set(E value) {
    checkState(latch.getCount() > 0, "Cannot call set more than once.");
    this.value = value;
    latch.countDown();
  }

  @Override
  public E get() {
    latch.await(); // will block until set() is called
    return value;
  }
}