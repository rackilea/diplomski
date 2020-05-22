public static <T, K, V> Map<K, List<V>> groupBy(
    Iterable<T> list,
    Function<T, K> keyMapper,
    Function<T, V> valueMapper) {
  Stream<T> stream = StreamSupport.stream(list.spliterator(), false);
  return stream
      .collect(
          Collectors.groupingBy(keyMapper,
          Collectors.mapping(valueMapper, Collectors.toList())));
}