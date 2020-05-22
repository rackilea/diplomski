double goldenRatio(double a, double b, double epsilon) {
    if(Math.abs((b / a) - ((a + b) / b)) < epsilon) {
        return ((a + b) / b);
    } else {
        return goldenRatio(b, a + b, epsilon);
    }
}