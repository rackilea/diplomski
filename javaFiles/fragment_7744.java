public static int multiplyPolynomials(int n, int m) {
    int result = 0x00000000;

    for (int i = 0; i < 32; i++) {
        int mask = 1 << i;

        if ((n & mask) == mask) {
            result += m << i;
        }
    }
    return result;
}