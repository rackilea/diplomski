public static boolean findPrimeFactors(int n) {
    Set<Integer> primeFactorSet = new HashSet<>();
    while (n % 2 == 0) {
        // here number is even so adding 2
        primeFactorSet.add(2);
        n /= 2;
    }

    // number would be odd in this loop
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
        while (n % i == 0) {
            primeFactorSet.add(i);
            n /= i;
        }
    }

    if (n > 2) {
        primeFactorSet.add(n);
    }

    // true if the unique prime-factors are greater than or equal to 4
    return primeFactorSet.size() >= 4 ? true : false;
}