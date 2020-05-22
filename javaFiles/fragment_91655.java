static int func(int n) {
    if (n < 1) return 0;   // as you required, F(0) = 0
    int n1 = 1, n2 = 1;    // however, for F(2..) we must have F(0) = 1
    for (int i = 2; i <= n; i++) {
        int n0 = n1 + n2;
        n2 = n1;
        n1 = n0;
    }
    return n1;
}