public class Main {
public static void main(String[] args) {
    String s = "(0, 0) (1, 2)";
    String[] rawCoords = s.split("\\) \\(");
    Point p1 = parsePoint(rawCoords[0]);
    Point p2 = parsePoint(rawCoords[1]);
    System.out.println(p1.distance(p2));

}

private static Point parsePoint(String s) {
    //remove all brackets and white spaces and split by comma
    String[] rawXY = s.replaceAll("[\\)\\(\\s]", "").split(",");
    return new Point(Integer.parseInt(rawXY[0]), Integer.parseInt(rawXY[1]));
}

public static class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point another) {
        return Math.sqrt(Math.pow(x - another.x, 2) + Math.pow(y - another.y, 2));
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}