public static <T> boolean isOrdered(Iterable<T> list, Comparator<? super T> c) {
  Iterator<T> i = list.iterator();
  if (i.hasNext()) {
    T previous = i.next();
    while (i.hasNext()) {
      T current = i.next();
      if (c.compare(previous, current) > 0)
        return false;
      previous = current;
    }
  }
  return true;
}