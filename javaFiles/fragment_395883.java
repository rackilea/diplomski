final Map<Point, String> names = ...;
final Set<Point> stations = names.keySet();
final Point source = ...;
final Point nearest = Collections.min(stations, new Comparator<Point>() {

  public int compare(final Point p1, final Point p2) {
    return (int) p1.distanceSq(p2);
  }
});
final String name = names.get(nearest);