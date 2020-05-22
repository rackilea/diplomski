static boolean isPowerOf10(long n) {
    while(n > 1 && n % 10 == 0){
        n /= 10;
    }
    return n == 1;
}