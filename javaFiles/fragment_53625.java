static long gcd(long a, long b) {
    while(b > 0) {
        a %= b;
        if (a == 0) return b;
        b %= a;
    }
    return a;
}