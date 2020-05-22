public class BezierCurve {
    private CubicCurve2D curve;

    private static final int delta = 100;

    private double x1, y1, x2, y2;
    private double ctrlx1, ctrly1, ctrlx2, ctrly2;

    public BezierCurve(Point p1, Side side1, Point p2, Side side2) {
        this.x1 = p1.x;
        this.y1 = p1.y;
        this.x2 = p2.x;
        this.y2 = p2.y;

        Point ctrl1 = getControlPoint(p1, side1);
        Point ctrl2 = getControlPoint(p2, side2);

        ctrlx1 = ctrl1.x;
        ctrly1 = ctrl1.y;
        ctrlx2 = ctrl2.x;
        ctrly2 = ctrl2.y;

        curve = new CubicCurve2D.Double();
        curve.setCurve(x1, y1, ctrlx1, ctrly1, ctrlx2, ctrly2, x2, y2);
    }

    private Point getControlPoint(Point p, Side s) {
        int x = p.x;
        int y = p.y;

        switch (s) {
        case Left:
            x -= delta;
            break;
        case Right:
            x += delta;
            break;
        case Bottom:
            y += delta;
            break;
        case Top:
            y -= delta;
            break;
        }
        return new Point(x, y);
    }

    public void draw(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.draw(curve);
    }
}