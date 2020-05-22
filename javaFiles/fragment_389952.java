public static long f(int n) {
    long n2 = 0;
    for (int i = 0; i < n; ++i) {
        if ((n & (1 << i)) == 1) { // i'th bit set?
            int bits = 32 - Integer.numberOfLeadingZeros(i);
            n2 <<= bits;
            n2 |= i;
        }
    }
    return n2;
}