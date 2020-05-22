public static double covariance(double[] xs, double[] ys) {
    double xmean = mean(xs);
    double ymean = mean(ys);
    return IntStream.range(0, Math.min(xs.length, ys.length))
        .parallel()
        .mapToDouble(i -> {
                double numerator = (xs[i] - xmean) * (ys[i] - ymean);
                double denominator = ...;
                return numerator / denominator;
            })
        .sum();
}