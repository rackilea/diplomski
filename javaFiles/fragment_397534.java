public class ColourFullShape implements Shape {
    private Shape shape;
    private boolean state;

    public ColourFullShape(Shape shape, boolean state) {
        this.shape = shape;
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public Shape getShape() {
        return shape;
    }

    @Override
    public Rectangle getBounds() {
        return getShape().getBounds();
    }

    @Override
    public Rectangle2D getBounds2D() {
        return getShape().getBounds2D();
    }

    @Override
    public boolean contains(double x, double y) {
        return getShape().contains(x, y);
    }

    @Override
    public boolean contains(Point2D p) {
        return getShape().contains(p);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return getShape().intersects(x, y, w, h);
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return getShape().intersects(r);
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return getShape().contains(x, y, w, h);
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return getShape().contains(r);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return getShape().getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return getShape().getPathIterator(at, flatness);
    }

}