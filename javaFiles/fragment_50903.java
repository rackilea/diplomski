public class Mul2d {
    public static double[] apply0(double angle, double[] X) {
        int n = X.length/2;
        double[] Y = new double[2*n];
        double cosv = Math.cos(angle);
        double sinv = Math.sin(angle);
        for (int i = 0; i < n; i++) {
            int at = 2*i;
            Y[at + 0] = cosv*X[at + 0] - sinv*X[at + 1];
            Y[at + 1] = sinv*X[at + 0] + cosv*X[at + 1];
        }
        return Y;
    }

    public static double[] apply(double angle, double[] X) {
        int n = X.length/2;
        double[] Y = new double[2*n];
        double cosv = Math.cos(angle);
        double sinv = Math.sin(angle);
        for (int i = 0; i < n; i++) {
            int at = 2*i;
            Y[at] = cosv*X[at] - sinv*X[at + 1];
            Y[at + 1] = sinv*X[at] + cosv*X[at + 1];
        }
        return Y;
    }
}