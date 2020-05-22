static boolean isPrime(int number) {
    boolean prime = true;
    if (number == 0 || number == 1 || number == -1)
        return false;
    for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) {
            prime = false;
            break;
        }
    }
    return prime;
}