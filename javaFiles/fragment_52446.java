public static double getDistance(Point point, JComponent comp) {

    Point loc = comp.getLocation();

    loc.x += comp.getWidth() / 2;
    loc.y += comp.getHeight() / 2;

    double xdif = Math.abs(loc.x - point.x);
    double ydif = Math.abs(loc.y - point.y);

    return Math.sqrt((xdif * xdif) + (ydif * ydif));
}