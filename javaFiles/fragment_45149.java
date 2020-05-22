CacheLoader<Point, Point> loader = new CacheLoader<Point, Point>() {
  @Override
  public Point load(final Point point) {
    return point;
  }
}
...
Point center = cache.get(new Point(0, 0));