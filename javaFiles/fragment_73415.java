private static boolean isPrime(int n) {
    if (n % 2 == 0) return n == 2;
    if (n % 3 == 0) return n == 3;
    int step = 4, m = (int)Math.sqrt(n) + 1;
    for(int i = 5; i < m; step = 6-step, i += step) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}