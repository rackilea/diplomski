public static final boolean belongsQuadratic2 (Point p, Point p0, Point p1, Point p2) {
    double ax = p0.x - 2*p1.x + p2.x;
    double bx = 2*p1.x - 2*p0.x ;
    double cx = p0.x - p.x;

    double ay = p0.y - 2*p1.y + p2.y;
    double by = 2*p1.y - 2*p0.y ;
    double cy = p0.y - p.y;

    // "Candidate" for t:
    double t = -(cx*ay - cy*ax)/(bx*ay - by*ax);
    if (t < 0 || t > 1)
        return false;
    // Compute the point corresponding to this candidate value ...
    Point q = Bezier.quadratic(p0, p1, p2, t);
    // ... and check if it is near the given point p:
    return Math.abs(q.x - p.x) <= 1 && Math.abs(q.y - p.y) <= 1;
}