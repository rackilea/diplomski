public static Boolean[] Flip(Boolean[] A, int n) {
    for (int i = 0; i < n / 2.0; i++) {
        boolean tmp = A[i];
        A[i] = !A[n - i - 1];
        A[n - i - 1] = !tmp;
    }

    return A;
}