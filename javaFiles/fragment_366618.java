import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;


public class ArrayQueueTest {

  @Test
  public void enqueue_withInitialCapacity0() {
    // Given an ArrayQueue with initialCapacity 0.
    int initialCapacity = 0;
    ArrayQueue<Integer> q = new ArrayQueue<Integer>(initialCapacity);

    // When enqueue is called.
    q.enqueue(0);

    // Then ArrayQueue resizes backing array to 1 and adds element.
    assertEquals(Arrays.asList(0), Arrays.asList(q.getBackingArray()));
  }

  @Test
  public void enqueue_lessThanCapacity() {
    // Given an ArrayQueue with some initialCapacity.
    ArrayQueue<Integer> q = new ArrayQueue<Integer>(2);

    // When less than capacity elements are enqueued.
    q.enqueue(0);

    // Then ArrayQueue adds elements to backing array.
    assertEquals(Arrays.asList(0, null), Arrays.asList(q.getBackingArray()));
  }

  @Test
  public void enqueue_toCapacity() {
    // Given an ArrayQueue with some initialCapacity.
    ArrayQueue<Integer> q = new ArrayQueue<Integer>(2);

    // When initialCapacity elements are enqueued.
    q.enqueue(0);
    q.enqueue(1);

    // Then ArrayQueue adds elements to backing array.
    assertEquals(Arrays.asList(0, 1), Arrays.asList(q.getBackingArray()));
  }

  @Test
  public void enqueue_withResize() {
    // Given an ArrayQueue is at capacity.
    int initialCapacity = 2;
    ArrayQueue<Integer> q = new ArrayQueue<Integer>(initialCapacity);
    q.enqueue(0);
    q.enqueue(1);

    // When enqueue is called again.
    q.enqueue(2);

    // Then ArrayQueue is capacity is doubled and element is added.
    int expectedCapacity = 2 * initialCapacity;
    assertEquals(expectedCapacity, q.getBackingArray().length);
    assertEquals(Arrays.asList(0, 1, 2, null), Arrays.asList(q.getBackingArray()));
  }

  @Test(expected = NoSuchElementException.class)
  public void dequeue_isEmpty() {
    // Given an empty ArrayQueue.
    ArrayQueue<Integer> q = new ArrayQueue<Integer>();

    // Throws when dequeue is called.
    q.dequeue();
    fail("Should have thrown NoSuchElementException.");
  }

  @Test
  public void dequeue() {
    ArrayQueue<Integer> q = new ArrayQueue<Integer>(4);
    q.enqueue(0);
    q.enqueue(1);
    q.enqueue(2);

    assertEquals(3, q.size());
    assertEquals(0, q.front());
    assertEquals(3, q.back());
    assertEquals(Arrays.asList(0, 1, 2, null), Arrays.asList(q.getBackingArray()));

    assertEquals(0, (int) q.dequeue());
    assertEquals(2, q.size());
    assertEquals(1, q.front());
    assertEquals(3, q.back());
    assertEquals(Arrays.asList(null, 1, 2, null), Arrays.asList(q.getBackingArray()));

    assertEquals(1, (int) q.dequeue());
    assertEquals(1, q.size());
    assertEquals(2, q.front());
    assertEquals(3, q.back());
    assertEquals(Arrays.asList(null, null, 2, null), Arrays.asList(q.getBackingArray()));

    assertEquals(2, (int) q.dequeue());
    assertEquals(0, q.size());
    assertEquals(3, q.front());
    assertEquals(3, q.back());
    assertEquals(Arrays.asList(null, null, null, null), Arrays.asList(q.getBackingArray()));
  }

  @Test
  public void loopAround_enqueue() {
    // Given an ArrayQueue with elements that have been dequeued.
    ArrayQueue<Integer> q = new ArrayQueue<Integer>(4);
    q.enqueue(0);
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.dequeue();
    q.dequeue();

    assertEquals(2, q.size());
    assertEquals(2, q.front());
    assertEquals(0, q.back());
    assertEquals(Arrays.asList(null, null, 2, 3), Arrays.asList(q.getBackingArray()));

    // When enqueue is called.
    q.enqueue(4);
    q.enqueue(5);

    // Then resize is not called and elements are added to the front beginning of the array.
    assertEquals(4, q.size());
    assertEquals(2, q.front());
    assertEquals(2, q.back());
    assertEquals(Arrays.asList(4, 5, 2, 3), Arrays.asList(q.getBackingArray()));
  }


  @Test
  public void loopAround_enqueue_withResize() {
    // Given an ArrayQueue that loops around and is at capacity.
    ArrayQueue<Integer> q = new ArrayQueue<Integer>(4);
    q.enqueue(0);
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.dequeue();
    q.dequeue();
    q.enqueue(4);
    q.enqueue(5);
    assertEquals(Arrays.asList(4, 5, 2, 3), Arrays.asList(q.getBackingArray()));

    // When enqueue is called.
    q.enqueue(6);

    // Then ArrayQueue resizes and reorders the backing array before adding the element.
    assertEquals(5, q.size());
    assertEquals(0, q.front());
    assertEquals(5, q.back());
    assertEquals(Arrays.asList(2, 3, 4, 5, 6, null, null, null), Arrays.asList(q.getBackingArray()));
  }

  @Test
  public void loopAround_dequeue() {
    ArrayQueue<Integer> q = new ArrayQueue<Integer>(4);
    q.enqueue(0);
    q.enqueue(1);
    q.enqueue(2);
    q.dequeue();
    q.enqueue(3);
    q.enqueue(4);

    assertEquals(4, q.size());
    assertEquals(1, q.front());
    assertEquals(1, q.back());
    assertEquals(Arrays.asList(4,1,2,3), Arrays.asList(q.getBackingArray()));

    assertEquals(1, (int) q.dequeue());
    assertEquals(3, q.size());
    assertEquals(2, q.front());
    assertEquals(1, q.back());
    assertEquals(Arrays.asList(4, null, 2, 3), Arrays.asList(q.getBackingArray()));

    assertEquals(2, (int) q.dequeue());
    assertEquals(2, q.size());
    assertEquals(3, q.front());
    assertEquals(1, q.back());
    assertEquals(Arrays.asList(4, null, null, 3), Arrays.asList(q.getBackingArray()));

    assertEquals(3, (int) q.dequeue());
    assertEquals(1, q.size());
    assertEquals(0, q.front());
    assertEquals(1, q.back());
    assertEquals(Arrays.asList(4, null, null, null), Arrays.asList(q.getBackingArray()));

    assertEquals(4, (int) q.dequeue());
    assertEquals(0, q.size());
    assertEquals(1, q.front());
    assertEquals(1, q.back());
    assertEquals(Arrays.asList(null, null, null, null), Arrays.asList(q.getBackingArray()));
  }
}