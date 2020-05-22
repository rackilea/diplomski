/**
 * Returns twice the signed area of the triangle a-b-c.
 * @param a first point
 * @param b second point
 * @param c third point
 * @return twice the signed area of the triangle a-b-c
 */
public static double area2(Point2D a, Point2D b, Point2D c) {
    return (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
}

/**
 * Returns the Euclidean distance between this point and that point.
 * @param that the other point
 * @return the Euclidean distance between this point and that point
 */
public double distanceTo(Point2D that) {
    double dx = this.x - that.x;
    double dy = this.y - that.y;
    return Math.sqrt(dx*dx + dy*dy);
}