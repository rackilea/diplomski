public <T> Foo getFoo (Multimap<T, List<Bar>> bars, Set<T> set) {
   for (T item : aSet) {

      // compile error: get(capture#621 of ?) in Multimap ... cannot be applied to java.lang.Object
      for (Bar bar : bars.get (item)) {
         //build foo;
      }
   }
   ...
}