protected Integer featureValueOf(Iterable<E> actual) {
  int size = 0;
  for (Iterator<E> iterator = actual.iterator(); iterator.hasNext(); iterator.next()) {
    size++;
  }
  return size;
}