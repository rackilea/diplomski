static long catalan(int n) {
    return c(1, n);
}

static long c(int i, int n) {
    if (n <= 1) {
        return 1;
    } else if (i > n) {
        return 0;
    } else {
        return catalan(i - 1) * catalan(n - i) + c(i + 1, n);
    }
}