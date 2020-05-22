public static <T extends Comparable<? super T>> boolean isOrdered(Iterable<T> list) {
  Iterator<T> i = list.iterator();
  if (i.hasNext()) {
    T previous = i.next();
    while (i.hasNext()) {
      T current = i.next();
      if (previous.compareTo(current) > 0)
        return false;
      previous = current;
    }
  }
  return true;
}