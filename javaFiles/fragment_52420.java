private enum Solutions {
    A(new double[] {1.5, 1.8, 1.9, 2.3, 2.7, 3.0}),
    B(new double[] {1.2, 1.8, 1.9, 2.4, 2.9, 3.1}),
    C(new double[] {}),
    D(new double[] {}),
    E(new double[] {1.4, 1.7, 1.8, 1.9, 2.3, 2.9} ) ;

    private double[] val;

    private Solutions(double[] pVal) {
        this.val = pVal;
    }
}