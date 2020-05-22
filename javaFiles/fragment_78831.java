public class LinkedBinaryHeap<E extends Comparable<E>> {
  private LinkedList<HeapNode, E> heap;

  public LinkedBinaryHeap(){
      heap = new LinkedList<HeapNode, E>();
  }