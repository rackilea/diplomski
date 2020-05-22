interface CompareOp {
  int compare(Object o1, Object o2);
}

// Inside some class, call it Klass
public static int compare ( CompareOp comparator, Object o1, Object o2) {
   return comparator.compare(o1, o2);
}