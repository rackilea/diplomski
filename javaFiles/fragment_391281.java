public class Circle {
    private double radius;

    public Circle(double inRadius) throws ShapeException {
        if(inRadius < 0.0) {
            throw new ShapeException("Shape Exception Occurred...");
        } else {
            radius = inRadius;
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius) throws ShapeException {
        if(newRadius < 0.0) {
            throw new ShapeException("Shape Exception Occurred...");
        } else {
            radius = newRadius;
        }
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public void stretchBy(double factor) throws ShapeException {
        if(factor < 0.0) {
            throw new ShapeException("Shape Exception Occurred...");
        } else {
            radius = radius * factor;
        }
    }

    @Override
    public String toString() {
        return "Circle Radius: " + radius;
    }
}