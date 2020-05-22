public class ArrayQueue<T> {
  private T[] backing;
  private int size;
  private int front;
  private int back;


  public ArrayQueue() {
    backing = (T[])new Object[INITIAL_CAPACITY];
    size = 0;
    front = 0;
    back = 0;
  }

  public ArrayQueue(int initialCapacity) {
    backing = (T[]) new Object[initialCapacity];
    size = 0;
    front = 0;
    back = 0;
  }

  public void enqueue(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Data is null.");
    }
    if (size() == backing.length) {
      resize();
    }
    backing[back] = data;
    back = (back + 1) % backing.length;
    size++;
  }

  private void resize() {
    T[] backingCopy = (T[]) new Object[backing.length == 0 ? 1 : backing.length * 2];
    // Insert elements from backing array to backingCopy in order.
    System.arraycopy(backing, front, backingCopy, 0, backing.length - front);
    System.arraycopy(backing, 0, backingCopy, backing.length - front, back);
    front = 0;
    back = backing.length;
    backing = backingCopy;
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException("Queue is empty.");
    }
    T returnData = backing[front];
    backing[front] = null;
    front = (front + 1) % backing.length;
    size--;
    return returnData;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  int front() {
    return front;
  }

  int back() {
    return back;
  }

  Object[] getBackingArray() {
    return backing;
  }

  static final int INITIAL_CAPACITY = 100;
}