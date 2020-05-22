/**
 * A 2-dimensional shape. 
 * It has area.
 * Its supersize() method should return a Shape2D instance.
 */
public interface Shape2D<T extends Shape2D<T>> extends GeometricShape<T> {

    double area();
}

/**
 * A rectangle.
 */
public final class Rectangle implements Shape2D<Rectangle> {

    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public void describe() {
        System.out.println(this);
    }

    @Override
    public Rectangle supersize() {
        return new Rectangle(width*2, height*2);
    }

    @Override
    public double area() {
        return width * height;
    }
}