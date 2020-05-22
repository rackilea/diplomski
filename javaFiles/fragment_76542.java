public final class Point {
    private final int x;
    private final int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
    @Override
    public int hashCode() {
        return this.x * 127 + this.y;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point that = (Point) obj;
            return (this.x == that.x && this.y == that.y);
        }
        return false;
    }
}