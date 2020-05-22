private Point[] getAdj(Point p, char[][] cMap) {
    List<Point> ret = new ArrayList<Point>();
    if (p.getX() != 0) // <<== Use != instead of ==
        ret.add(new Point(p.getX() - 1, p.getY()));
    if (p.getX() != cMap.length - 1)
        ret.add(new Point(p.getX() + 1, p.getY()));
    if (p.getY() != 0) // <<== Use != instead of ==
        ret.add(new Point(p.getX(), p.getY() - 1));
    if (p.getY() != cMap[p.getX()].length - 1)
        ret.add(new Point(p.getX(), p.getY() + 1));

    return ret.toArray(new Point[ret.size()]);
}