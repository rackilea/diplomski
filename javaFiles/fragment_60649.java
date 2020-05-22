public static <K, V> boolean isUnique(Map<K, V> input) {
  if (input == null || input.isEmpty()) {
    return true;
  }
  Set<V> set = new HashSet<V>();
  for (V value : input.values()) {
    set.add(value);
  }
  return set.size() == input.size();
}