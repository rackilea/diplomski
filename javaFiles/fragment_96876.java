public class Cercle {

    private Double radius;
    private Double pi = Math.PI;

    public Cercle(String rad) {
        radius = Double.valueOf(rad);
    }

    double getPI() {
        return pi;
    }
    double getRadius() {
        return radius;
    }
    public double computeDiameter() {
        return 2 * radius;
    }
    double computePerimeter() {
        return pi * 2 * radius;
    }
    double computeArea() {
        return (pi * Math.pow(radius, 2));
    }
}