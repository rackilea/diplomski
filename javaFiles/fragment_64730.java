public static void main(String[] args) {
    double [] foo = new double[10];
    foo[5] = 10;                            // Sets the sixth element to 10
    for (int i = 0; i < foo.length; i++) {
        double val = foo[i];
        if (val != 0) {
            System.out.printf("foo[%d] = %f\n", i, val);
        }
    }
}