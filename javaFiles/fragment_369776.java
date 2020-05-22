private static long compute(long n) {
    int a = 1;
    int b = 1;
    for (int i = 0, max = (int) (n % 1000000); i < max; i++) {
        int next = b * b + a;
        a = b;
        b = next % 1000;
    }
    return b % 1000;
}