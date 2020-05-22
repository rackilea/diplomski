public class Interpolate {

    public static void main(String[] args) {
        double[] x = { 0, 50, 100 };
        double[] y = { 0, 50, 200 };

        LinearInterpolator interp = new LinearInterpolator();
        PolynomialSplineFunction f = interp.interpolate(x, y);

        System.out.println("Piecewise functions:");
        Arrays.stream(f.getPolynomials()).forEach(System.out::println);

        double value = f.value(70);
        System.out.println("y for xi = 70: " + value);
    }
}