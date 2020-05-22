public double[] colMean(double[][] data) {
    double[] x = new double[data[0].length];
    for (int i = 0; i < x.length; i++) {
        x[i] = data[0][i];
    }
    return x;
}