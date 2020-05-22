double[] x = { 1.0, 0.90, 0.80, 0.70, 0.60, 0.50, 0.40, 0.30, 0.20,
           0.10, 0.00, -0.10, -0.20, -0.30, -0.40, -0.50, -0.60, -0.70,
           -0.80, -0.90, -1.00 };

double r = 1;

for (int i = 0; i < x.length; i++) {
    double y = Math.sqrt(Math.pow(r, 2) - Math.pow(x[i], 2));
    System.out.printf("%10.2f%10.2f%n", x[i], y);
}