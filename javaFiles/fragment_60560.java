new AbstractList<T>() {
   public T get(int i) {
     Preconditions.checkElementIndex(i, size);
     return function.apply(i);
   }
   public int size() {
     return size;
   }
 }