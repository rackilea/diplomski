public static int[] shuffle(int n, BigInteger random_index) {
    int[] perm = new int[n];
    BigInteger[] fact = new BigInteger[n];
    fact[0] = BigInteger.ONE;
    for (int k = 1; k < n; ++k) {
        fact[k] = fact[k - 1].multiply(BigInteger.valueOf(k));
    }

    // compute factorial code
    for (int k = 0; k < n; ++k) {
        BigInteger[] divmod = random_index.divideAndRemainder(fact[n - 1 - k]);
        perm[k] = divmod[0].intValue();
        random_index = divmod[1];
    }

    // readjust values to obtain the permutation
    // start from the end and check if preceding values are lower
    for (int k = n - 1; k > 0; --k) {
        for (int j = k - 1; j >= 0; --j) {
            if (perm[j] <= perm[k]) {
                perm[k]++;
            }
        }
    }

    return perm;
}

public static void main (String[] args) {
    System.out.printf("%s\n", Arrays.toString(
        shuffle(52, new BigInteger(
            "7890123456789012345678901234567890123456789012345678901234567890"))));
}