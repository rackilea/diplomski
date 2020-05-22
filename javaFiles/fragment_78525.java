public void drawSquare(Point A, Point B, Point mouse) {
    // v is the normal vector or line (AB) which norm is distance(A,B)
    Point v = new Point(B.x - A.x,A.y- B.y);
    v       = v.dot(mouse.subtract(B)) < 0 ? v.opposite() : v;
    // translate A and B and draw the square
    draw(new Square(A,B,B.sum(v),A.sum(v)));
}