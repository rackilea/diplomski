Comparator<Point> cmp = (p1, p2) -> {
  int cmpx = Integer.compare(p1.x, p2.x);
  if (cmpx != 0) {
    return cmpx;
  }
  return Integer.compare(p1.y, p2.y);
};