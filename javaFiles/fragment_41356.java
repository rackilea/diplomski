public static int sumDivByX(int n, int x) {
    int total = 0;
    if (n == 0 || x == 0) {
        return 0;
    }
    if (n % x >= 1) {
        total = 0;
    } else if (n % x == 0) {
        total += n;
    }
    return total + sumDivByX(n - 1, x);

}