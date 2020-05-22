long fibbonaci(int n) {
    long c = 0, k = 1;
    for (int i = 0; i < n; i++) {
        k += c;
        c = k - c;
    }
    return c;
}