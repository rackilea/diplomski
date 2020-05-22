public static int getIndex(int a1, int a2, int a3, int a4, int a5, int a6, int a7) {
    return 133784559 - (C7[a1] + C6[a2] + C5[a3] + C4[a4] + C3[a5] + C2[a6] + (51 - a7));
}

static final int[] C2 = Ck(2), C3 = Ck(3), C4 = Ck(4), C5 = Ck(5), C6 = Ck(6), C7 = Ck(7);

// Creates a cache of C(51-i, k) for 0 <= i < 52
static int[] Ck(int k) {
    int[] result = new int[52];
    for (int i = 0; i < 52; i++) {
        result[i] = (int) C(51 - i, k);
    }
    return result;
}

// Computes binomial coefficient C(n, k)
static long C(int n, int k) {
    long C = 1;
    for (int i = 0; i < k; i++) {
        C = C * (n - i) / (i + 1);
    }
    return C;
}