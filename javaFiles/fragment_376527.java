static boolean isPrime(int n) {
 for (int i = 2; i < n; i++) {
        if (n % i == 0 && i != n) return false;
    }
return true;
}