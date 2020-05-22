abstract class AbstractVector {
    protected Point startPoint;
    public Point getStart() {
        return startPoint;
    }
    public abstract Point getEnd();
    //Methods, e.g. length(), getter...
}

class Vector extends AbstractVector {
    protected Point endPoint;
    public Point getEnd() {
        return endPoint;
    }
}

class TriVector extends AbstractVector {
    protected Point[] endPoints = new Point[2];
    protected int activeEndPoint = 0;

    public Point getEnd() {
        return endPoints[activeEndPoint];
    }

    public void switchEnds() {
        activeEndPoint = 1 - activeEndPoint;
    }
}