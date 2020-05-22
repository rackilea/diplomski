public static int sumDivByX(int n, int x) {
    if (n == 0 || x == 0) {
        return 0;
    }
    return (n % x == 0 ? n : 0) + sumDivByX(n - 1, x);
}