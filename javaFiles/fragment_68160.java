static long multiply(long a, long b, long M) {
    long res = 0;
    long d = a % M;

    while (b > 0) {
        if ((b & 1) == 1) {
            res = (res + d) % M;
        }

        b >>= 1;
        d = (d + d) % M;
    }
    return res;
}