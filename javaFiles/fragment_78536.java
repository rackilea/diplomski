final List<Iterator<E>> theIterators;
return new AbstractIterator<E>() {
  private Queue<Iterator<E>> queue = new LinkedList<Iterator<E>>(theIterators);
  @Override protected E computeNext() {
    while(!queue.isEmpty()) {
      Iterator<E> topIter = queue.poll();
      if(topIter.hasNext()) {
        E result = topIter.next();
        queue.offer(topIter);
        return result;
      }
    }
    return endOfData();
  }
};