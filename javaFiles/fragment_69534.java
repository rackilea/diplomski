private static boolean isPrime(int toCheck) {
    for (int i = 2; i < toCheck; i++) {
        // stop iterating if you know number is even
        if (toCheck % i == 0) return false;
    }
    return true;
}