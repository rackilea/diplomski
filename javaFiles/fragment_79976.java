public static void findDerivative(Function f, double lowerBound, double upperBound, double step) {
    double fxstep = f.f(x);

    for (double x = lowerBound; x <= upperBound; x += step) {
        double fx = fxstep;
        fxstep = f.f(x+step);
        double dy = (fxstep - fx) / step;
        if (dy < 0.01 && dy > -0.01) {
            System.out.println("The x value is " + x + ". The value of the "
                    + "derivative is " + dy);
        }
    }
}