public static <T> boolean hasduplicateList(List<List<T>> lists) {
  return 
    lists.stream()  // create a <Stream<List<T>>
         .map(HashSet::new) // transform Stream<List<T>> to Stream<HashSet<T>> 
         .distinct() // keep only distinct Sets
         .count() < lists.size();
}