public static <K, V> NavigableMap<K, V> asNavigableMap(List<V> items, Function<V, K> mapper) {
  NavigableMap<K, V> navMap = new TreeMap<>();
  for (V item : items)
    navMap.put(mapper.apply(item), item);
  return navMap;
}