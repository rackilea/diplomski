public static int sumfib_r (int a, int b, int n) {
    if (n == 1) return a;
    if (n == 2) return b;
    return sumfib_r(b, a+b+1, n-1);
}

public static int sumfib (int n) {
    return sumfib_r(0, 1, (n > 0) ? n : 1);
}