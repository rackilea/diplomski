public static <T> Stream<T> enumerationAsStream(Enumeration<T> e) {
     return StreamSupport.stream(
         Spliterators.spliteratorUnknownSize(
             new Iterator<T>() {
                 public T next() {
                     return e.nextElement();
                 }
                 public boolean hasNext() {
                     return e.hasMoreElements();
                 }
             },
             Spliterator.ORDERED), false);
 }