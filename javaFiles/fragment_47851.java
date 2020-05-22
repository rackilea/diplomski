public class sample {

    public static void main(String[] args) {
        System.out.println(poly(2, 2, 2, 2));
    }

    public static double poly(double c, double b, double a, double x) {
        double y = c + b * x + a * x * x;
        return y;
    }
}