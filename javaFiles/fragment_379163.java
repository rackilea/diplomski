public abstract class Shape {

    private Point center;

    public Shape(Point p) {
       this.center = p;
    }

    public abstract void draw();

    public void erase() {
        setColor(backgroundColor);
        draw();
        setColor(foregroundColor);
    }
}