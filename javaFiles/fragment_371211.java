public static double largestPrimeFactor(long n) {
    double factor = 0;

    for (int j=(int)Math.sqrt(n); 1<j; j--) {
        if (n % j == 0 && isPrime(j)) {
            return j; // Changed this line
        }

    }
    return factor;
}