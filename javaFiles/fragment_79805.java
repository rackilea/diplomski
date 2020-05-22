public static Boolean[] Flip(Boolean[] A, int n) {
    Boolean[] Atemp = Arrays.copyOf(A , A.length);

    for (int i = 0; i < n; i++) {
        Atemp[i] = !A[n - i - 1];
    }

    return Atemp;
}