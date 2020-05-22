public static Shape createStar(int arms, Point center, double rOuter, double rInner) {
    double angle = Math.PI / arms;

    GeneralPath path = new GeneralPath();

    for (int i = 0; i < 2 * arms; i++) {
        double r = (i & 1) == 0 ? rOuter : rInner;
        Point2D.Double p = new Point2D.Double(
            center.x + Math.cos(i * angle) * r, 
            center.y + Math.sin(i * angle) * r);
        if (i == 0) {
            path.moveTo(p.getX(), p.getY());
        }
        else {
            path.lineTo(p.getX(), p.getY());
        }
    }
    path.closePath();
    return path;
}