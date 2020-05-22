private static boolean isPrime(int n) {
    for(int i = 2; i < n; ++i) {
        if (n % i == 0) {
            // We are naive, but not stupid, if
            // the number has a divisor other
            // than 1 or itself, we return immediately.
            return false;
        }
    }
    return true;
}