// This will work because you create new objects with same old values
public Point[] cloneArrayOfPoints(Point[] points) {
    Point[] result = new Point[points.length];
    for (int i = 0; i < points.length; i++){
        result.points[i] = new Point(points[i].getX(), points[i].getY());
    }
    return result;
}