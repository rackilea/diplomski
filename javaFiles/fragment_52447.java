public static double distance(Point p, JComponent comp) {
    Point2D.Float center =
        // note: use (0, 0) instead of (getX(), getY())
        // if the Point 'p' is in the coordinates of 'comp'
        // instead of the parent of 'comp'
        new Point2D.Float(comp.getX(), comp.getY());

    center.x += comp.getWidth() / 2f;
    center.y += comp.getHeight() / 2f;

    return center.distance(p);
}