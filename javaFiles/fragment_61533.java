public static List<Point> foo(List<List<Integer>> map) {
  return IntStream.range(0, map.size()) // IntStream
      .mapToObj(
          i ->
              IntStream.range(0, map.get(i).size())
                  .filter(j -> map.get(i).get(j) == 1)
                  .mapToObj(j -> new Point(i, j))) // Stream<Stream<Point>>
      .flatMap(Function.identity()) // Stream<Point>
      .collect(Collectors.toList()); // List<Point>
}