public class QuadraticEquation {

    //coefficients
    private double a;
    private double b;
    private double c;
    private double discriminant;

    //constructor
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        discriminant =  b * b - (4 * a * c);
    }

    // etc.