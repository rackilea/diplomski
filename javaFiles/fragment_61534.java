public static List<Point> foo(List<List<Integer>> map) {
  List<Point> result = new ArrayList<>();
  for (int i = 0; i < map.size(); i++) {
    List<Integer> inner = map.get(i);
    for (int j = 0; j < inner.size(); j++) {
      if (inner.get(j) == 1) {
        result.add(new Point(i, j));
      }
    }
  }
  return result;
}