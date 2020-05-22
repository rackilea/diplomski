public class Point {
    int x;
    int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
        System.out.printf("Created point %s at (%s,%s)%n", this, x, y);
    }

    void move(int dx, int dy) {
        x += dx;
        y += dy;
        System.out.printf("Moved point %s (%s,%s) from (%s,%s) to (%s,%s)%n", this, dx, dy, x - dx, y - dy, x, y);
    }
}