public abstract class ShapeDrawer<T extends Shape> {
    public abstract void draw(T shape);
}

public class CircleDrawer extends ShapeDrawer<Circle> {
    public void draw(Circle circle) { ... }
}