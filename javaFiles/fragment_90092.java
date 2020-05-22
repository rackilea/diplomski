public static <T> Collector<T, List<List<T>>, Stream<List<T>>> chunked(int chunkSize) {
  return Collector.of(
          ArrayList::new,
          (outerList, item) -> {
            if (outerList.isEmpty() || last(outerList).size() >= chunkSize) {
              outerList.add(new ArrayList<>(chunkSize));
            }
            last(outerList).add(item);
          },
          (a, b) -> {
            a.addAll(b);
            return a;
          },
          List::stream,
          Collector.Characteristics.UNORDERED
  );
}

private static <T> T last(List<T> list) {
  return list.get(list.size() - 1);
}