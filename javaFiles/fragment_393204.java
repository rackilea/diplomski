static double sum(double x, double x0, int n) {
    double sum = 0;
    for (int i = 0; i <= n; ++i) {
        sum += p(x, x0, i);
    }
    return sum;
}