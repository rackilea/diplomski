double[] x = {0, 1, 2, 3, 4, 5};
double[] y = new double[6];
for (int i = 0; i < 6; i++) {
    y[i] = 1 + 2 * x[i] + 3 * x[i] * x[i];
}
DividedDifferenceInterpolator divider = new DividedDifferenceInterpolator();
PolynomialFunctionNewtonForm polynom = divider.interpolate(x, y);
double[] coefficients = polynom.getCoefficients();
System.out.println(Arrays.toString(coefficients));
PolynomialFunction derivative =
 (PolynomialFunction) new PolynomialFunction(coefficients).derivative();
System.out.println(Arrays.toString(derivative.getCoefficients()));