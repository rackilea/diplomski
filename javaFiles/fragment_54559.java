class QueueSpliterator<T> extends Spliterators.AbstractSpliterator<T> {

  private final BlockingQueue<T> queue;

  public QueueSpliterator(BlockingQueue<T> queue) {
    super(Long.MAX_VALUE, 0);
    this.queue = queue;
  }

  public boolean tryAdvance(Consumer<? super T> action) {
    try {
      T element = queue.take();
      action.accept(element);
      return true;
    } catch (InterruptedException e) {
      return false;
    }
  }
}