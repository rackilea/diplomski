static int searchDescendingGT(double[] a, int i, int j, double x) {
    while (i <= j) {

        int m = (i + j) / 2;

        if (a[m] == x) {
            return m;
        } else if (a[m] < x) {
            j = m - 1;
        } else {
            i = m + 1;
        }
    }
    return -1;

}