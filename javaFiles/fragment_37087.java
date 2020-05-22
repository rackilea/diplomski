void processRemoval(Collection<E> collection) {
  synchronized(lock) {
    for (Iterator<E> iter = collection.iterator(); iter.hasNext(); ) {
      final E element = iter.next();
      if (shouldRemove(element) {
        iter.remove();
      }
    }
  }
}