public static Object[][] nestedListsToNestedArrays(
    Collection<? extends Collection<?>> source){
  Object[][] result = new Object[source.size()][];
  int i = 0;
  for (Collection<?> subCollection : source) {
    result[i++] = subCollection.toArray();
  }
  return result;
}