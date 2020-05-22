public static int ashishPartion(int[] a, int start, int end) {
    int n = end-start + 1;
    int[] b = new int[n];
    int bj = 0;
    int bk = n-1;
    int pivot = a[start];
    for (int i = start + 1; i <= end; i++) {
        if (a[i] < pivot) {
            b[bj++] = a[i];
        } else {
            b[bk--] = a[i];
        }
    }
    b[bj] = pivot;
    System.arraycopy(b, 0, a, start, n);
    return start+bj;
}