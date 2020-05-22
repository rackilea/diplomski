public static <T> T peekNext(ListIterator<T> iterator) {
  T next = iterator.next();
  iterator.previous();
  return next;
}

public static <T> T peekPrevious(ListIterator<T> iterator) {
  T previous = iterator.previous();
  iterator.next();
  return previous;
}