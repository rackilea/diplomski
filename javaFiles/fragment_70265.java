private static Point getDisplaySize(final Display display) {
final Point point = new Point();
try {
    display.getSize(point);
} catch (java.lang.NoSuchMethodError ignore) { // Older device
    point.x = display.getWidth();
    point.y = display.getHeight();
}
return point;
}