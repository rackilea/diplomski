public class Line extends Shape {
    private Point p1; // You may or may not want the `private`, it...
    private Point p2; // ...depends what you're going to do with them

    public Line(int x1, int x2, int y1, int y2, Color myColor) {
        super(x1, x2, y1, y2, myColor);

        this.p1 = new Point(this.getX1(),this.getY1());
        this.p2 = new Point(this.getX2(),this.getY2());
    }

    // ...
}