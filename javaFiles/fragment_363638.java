private Point calculateTopLeftCornerPoint(Point[] points) {
    Point corner = null;
    Integer d = null;
    for (Point point : points) {
      Integer diff = point.y - point.x;
      if (d == null || (diff) > d) {
        corner = point;
        d = diff;
      }
    }
    return corner;
  }