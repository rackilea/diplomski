public static int [][] concat(int a[], int b[]) {
    int res[][] = new int[a.length][2];
    if (a.length != b.length) {
        throw new IllegalArgumentException("lenght are not equal, cannot perform");
    }
    for (int i = 0; i < a.length; i++) {
        res[i][0] = a[i];
        res[i][1] = b[i];
    }
    return res;
}