private List<Point> flatDoublesToPoints(List<Double> flatDoubles) {
    List<Point> points = new ArrayList<>();
    for(int i = 0; i < flatDoubles.size(); i += 2) {
        points.add(new Point(flatDoubles.get(i), flatDoubles.get(i + 1)));
    }
    return points;
}

class Point {
    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}