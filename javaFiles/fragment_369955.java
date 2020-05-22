public class Point {
    private final double x;
    private final double y;

    public Point(x, y) { 
        this.x = x; 
        this.y = y;
    }

    public static double distance(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}