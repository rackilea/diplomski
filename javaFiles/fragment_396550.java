public class LinkedListCircularBuffer<E> extends LinkedList<E> {
  @Override
  public E get(int i) {
    return super.get(i % size()); // simpler and faster without an "if"
  }
}