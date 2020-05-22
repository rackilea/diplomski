private static <K, V> Map<K, V> makeMap(final int maxSize) {
  return CacheBuilder.newBuilder()
      .maximumSize(maxSize)
      .<K, V>build() // not using a cache loader
      .asMap();
}