// This won't work because you keep the same reference to the old objects
public Point[] cloneArrayOfPoints(Point[] points) {
    Point[] result = new Point[points.length];
    for (int i = 0; i < points.length; i++){
        result.points[i] = points[i];
    }
    return result;
}