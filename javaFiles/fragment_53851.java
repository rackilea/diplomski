private static <T extends Comparable<? super T>> void moveDownAux(T[] a, int min, int i, int max) {
    T e = a[i];
    int j;
    while((j = (2*i)+1 - min) < max) {
      if(j+1 < max && a[j+1].compareTo(a[j]) > 0) j++; /* Biggest son */
      if(e.compareTo(a[j]) >= 0) break;
      a[i] = a[j];
      i = j;
    }
    a[i] = e;
  }