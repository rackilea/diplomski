/**
 * A 3-dimensional shape. 
 * It has volume. 
 * Its supersize() method should return a Shape3D instance.
 */
public interface Shape3D<T extends Shape3D<T>> extends GeometricShape<T> {

    double volume();
}

/**
 * A sphere
 */
public final class Sphere implements Shape3D<Sphere> {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public void describe() {
        System.out.println(this);
    }

    @Override
    public Sphere supersize() {
        return new Sphere(radius*2);
    }

    @Override
    public double volume() {
        return 4*Math.PI*Math.pow(radius, 3)/3;
    }
}