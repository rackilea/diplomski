List<Point> points = ...;
Collections.sort(points, new Comparator<Point>() {
    @Override
    public int compare(Point p1, Point p2) {
        return Double.compare(p1.getX(), p2.getX());
    }
});