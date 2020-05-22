/**
 * returns true if the specified point is inside this triangle
 **/
public boolean contains(MyPoint p) {

    return contains(p.getX(), p.getY());
}

public boolean contains(double x, double y) {

    // Get max X & Y
    double maxX = getMax(p1.getX(), p2.getY(), p3.getX());
    double maxY = getMax(p1.getY(), p2.getY(), p3.getX());

    // Get min X & Y
    double minX = getMin(p1.getX(), p2.getX(), p3.getX());
    double minY = getMin(p1.getY(), p2.getY(), p3.getY());

    // Outside the bounding rectangle of the triangle
    if (x < minX || x > maxX || y < minY || y > maxY) return false;

    // Check if point is the border of the triangle
    MyPoint p = new MyPoint(x, y);
    boolean side1 = p.onTheLineSegment(p1, p2); //assume A to B
    boolean side2 = p.onTheLineSegment(p1, p3); //assume B to C
    boolean side3 = p.onTheLineSegment(p2, p3); //assume C to A
    return side1 || side2 || side3; //return true if any point of these vertices inside triangle.

}