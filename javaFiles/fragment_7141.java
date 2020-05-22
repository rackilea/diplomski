public static void main(String[] args) {
        int n = 10;
        double[] x = new double[n];
        x[5] = 7;
        x[1] = 31;
        for(double i: x) {
            System.out.println(i);
        }
    }