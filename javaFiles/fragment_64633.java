public class Line {

    private final Point p1, p2;
    private final LineFunction lineFunction;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.lineFunction = new LineFunction(this);
    }
    public Line(Line o) {
        this.p1 = o.p1;
        this.p2 = o.p2;
        this.lineFunction = new LineFunction(this);
    }
    public Line sum(Line other,Point p1,Point p2) {
        LineFunction s= this.lineFunction.sum(other.lineFunction);
        return new Line(new Point(p1.getX(),s.computeFor(p1.getX())),new Point(p2.getX(),s.computeFor(p2.getX())));
    }
    public boolean isInInterval(Point p) {
        return p.getX() >= this.p1.getX() && p.getX() < this.p2.getX();
    }

    @Override
    public String toString() {
        return "{"+p1+","+p2+"}";
    }

}