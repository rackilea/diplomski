double[][] source = new double[][]{{1, 1, 1, 2}, {1, 2, 2, 3}, {1, 2, 2, 3}, {1, 1, 3, 3}};
BicubicInterpolator bi = new BicubicInterpolator();
for (int i = -10; i <= 20; i++) {
    double idx = i / 10.0;
    System.out.printf("Result (%3.1f, %3.1f) : %3.1f%n", idx, idx, bi.getValue(source, idx, idx));
}