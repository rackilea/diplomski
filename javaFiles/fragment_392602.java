public class Square {
    private final Point v1;
    private final Point v2;
    private final Point v3;
    private final Point v4;

    public Square(Point v1, Point v2, Point v3, Point v4) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.RED);
        g.drawLine(v1.x, v1.y, v2.x, v2.y);
        g.drawLine(v2.x, v2.y, v3.x, v3.y);
        g.drawLine(v3.x, v3.y, v4.x, v4.y);
        g.drawLine(v4.x, v4.y, v1.x, v1.y);
    }

    public void nextSquare() {
        int x1=(1-t)*v1.x + t * v2.x;
        int y1=(1-t)*v1.y + t * v2.y;

        int x2=(1-t)*v2.x + t * v3.x;
        int y2=(1-t)*v2.y + t * v3.y;

        int x3=(1-t)*v3.x + t * v4.x;
        int y3=(1-t)*v3.y + t * v4.y;

        int x4=(1-t)*v4.x + t * v1.x;
        int y4=(1-t)*v4.y + t * v1.y;

        return new Square(
            new Point(x1, y1),
            new Point(x2, y2),
            new Point(x3, y3),
            new Point(x4, y4));
     }
 }