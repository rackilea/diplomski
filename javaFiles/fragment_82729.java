static int max(int a, int b, int n) {
    int extra = (n - Math.abs(a - b) - 1);
    if (n <= 2 || extra < 0)
        throw new IllegalArgumentException();
    return (extra == 0 ? Math.max(a, b) - 1 : Math.max(a, b) + extra / 2);
}