public static int mystery() {
    int[] a = { 1, 3, -10, 12, 3, 20 };
    int r = Math.abs(a[0] - a[1]);
    for (int i = 1; i < a.length; i++) {
        if (Math.abs(a[i - 1] - a[i]) > r) {
            r = Math.abs(a[i - 1] - a[i]);
        }
    }
    return r;
}