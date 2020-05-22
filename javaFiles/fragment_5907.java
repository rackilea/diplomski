public static void main(String[] args) {
    double[][] arr = { { 1, 10, 2.0 }, { 1, 11, 1.2 }, { 1, 12, 1.4 }, };
    ;
    Arrays.sort(arr, new Comparator<double[]>() {
        public int compare(double[] o1, double[] o2) {
            return Double.compare(o1[2], o2[2]);
        }
    });

    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[i][j]);
            System.out.print("\t");
        }
        System.out.println();
    }

}