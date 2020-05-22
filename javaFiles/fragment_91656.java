static int func(int n, int r) {
    if (n < 1) return 0;   // as you required, F(0) = 0
    if (n == 1 || r < 1) return 1;
    int[] a = new int[r + 1];
    a[r] = a[r-1] = 1;     // however, for F(2..) we must have F(0) = 1
    for (int i = 2; i <= n; i++) {
        int x = a[0];
        for (int j = 1; j <= r; j++) {
            x += a[j];
            a[j-1] = a[j];
        }
        a[r] = x;
    }
    return a[r];
}