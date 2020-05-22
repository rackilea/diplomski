public boolean totalIntersects(Polygon poly, Shape testShape) {
    List<Point> points = flatDoublesToPoints(poly.getPoints());
    boolean inside = true; // If this is false after testing all points, the poly has at least one point outside of the shape.
    for(Point point : points) {
        if(!testShape.intersects(point.x, point.y, 1, 1)) { // The 3rd and 4th parameters here are "width" and "height". 1 for a point.
            inside = false;
        }
    }
    return inside;
}