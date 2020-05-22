public static int nthPrime(int n) {
    int candidate, count;
    for(candidate = 2, count = 0; count < n; ++candidate) {
        if (isPrime(candidate)) {
            ++count;
        }
    }
    // The candidate has been incremented once after the count reached n
    return candidate-1;
}