double goldenRatio(double a, double b) {
    double epsilon = 0.00001;
    if(Math.abs((b / a) - ((a + b) / b)) < epsilon) {
        return ((a + b) / b);
    } else {
        return goldenRatio(b, a + b);
    }
}