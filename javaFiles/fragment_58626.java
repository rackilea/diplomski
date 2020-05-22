public static double weightedSum(double[] values, double[] weights) {
    double sum = 0;
    for (int i = 0; i < values.length; i++) {
        sum += values[i] * weights[i];
    }
    return sum;
}