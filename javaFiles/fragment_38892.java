public class Poly {

    public static double evaluate(double x, double [] coeffs) {
        double value = 0.0;
        if (coeffs != null) {
            // Use Horner's method to evaluate.
            for (int i = coeffs.length-1; i >= 0; --i) {
                value = coeffs[i] + (x*value);
            }
        }
        return value;
    }
}