public class Dot {

    private Point p;
    private Color color;

    public Dot(Point p, Color color) {
        this.p = p;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(p.x, p.y, 10, 10);
    }

}