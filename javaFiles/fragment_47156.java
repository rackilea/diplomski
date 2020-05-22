class Point {
  ...
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Point)) return false;
    Point rhs = (Point)obj;
    return x == rhs.x && y == rhs.y;
}