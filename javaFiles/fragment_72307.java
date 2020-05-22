public static double stdDev(double... a) {
    double sum = 0;
    double sq_sum = 0;
    for (int i = 0; i < n; ++i) {
        double ai = a[i];
        sum += ai;
        sq_sum += ai * ai;
    }
    double mean = sum / n;
    double variance = sq_sum / n - mean * mean;
    return Math.sqrt(variance);
}