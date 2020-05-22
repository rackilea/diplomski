package kpi.ua.shapes;


public class Line {
    private Point from;
    private Point to;
    public Line(Point from, Point to) {
        super();
        this.from = from;
        this.to = to;
    }
    public Point getFrom() {
        return from;
    }
    public void setFrom(Point from) {
        this.from = from;
    }
    public Point getTo() {
        return to;
    }
    public void setTo(Point to) {
        this.to = to;
    }
}