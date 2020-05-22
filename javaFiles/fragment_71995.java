private static double[] SelectionSort(double[] b) {
    double[] a = new double[b.length];
    System.arraycopy(b, 0, a, 0, b.length);
    int min=-1;
    for (int i = 0; i < a.length; i++) {
        min = i;
        for (int j = i + 1; j < a.length; j++) {
            if (a[min] > a[j]) {
                min = j;
            }
        }
        if (min != i) {
            double temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }
    return a;
}