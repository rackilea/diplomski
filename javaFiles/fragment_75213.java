public boolean addPoint(double x, double y) {
        Point2d a = new Point2d(x, y);
        p.add(points, a);
        points++;
        return true;
    }