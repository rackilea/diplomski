return new Iterator<E>() {
  private Queue<Iterator<E>> queue = new LinkedList<Iterator<E>>(theIterators);
  public boolean hasNext() {
    // If this returns true, the head of the queue will have a next element
    while(!queue.isEmpty()) {
      if(queue.peek().hasNext()) {
        return true;
      }
      queue.poll();
    }
    return false;
  }
  public E next() {
    if(!hasNext()) throw new NoSuchElementException();
    Iterator<E> iter = queue.poll();
    E result = iter.next();
    queue.offer(iter);
    return result;
  }
  public void remove() { throw new UnsupportedOperationException(); }
};