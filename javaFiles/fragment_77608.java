public static <T extends Comparable<? super T>> void sort(List<T> list) {
  Object[] a = list.toArray();
  Arrays.sort(a);
  ListIterator<T> i = list.listIterator();
  for (int j=0; j<a.length; j++) {
      i.next();
      i.set((T)a[j]);
  }
}