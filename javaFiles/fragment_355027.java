package kpi.ua.shapes;

public class Line3D {
    private Point3D from;
    private Point3D to;

    public Line3D() {
        super();
    }

    public Line3D(Point3D from, Point3D to) {
        super();
        this.from = from;
        this.to = to;
    }

    public Point3D getFrom() {
        return from;
    }

    public void setFrom(Point3D from) {
        this.from = from;
    }

    public Point3D getTo() {
        return to;
    }

    public void setTo(Point3D to) {
        this.to = to;
    }

    public Line get2DVision() {
        return new Line(from.get2DVision(), to.get2DVision());
    }
}