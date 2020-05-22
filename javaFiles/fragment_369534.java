public static int fib_r (int a, int b, int n) {
    if (n == 1) return a;
    if (n == 2) return b;
    return fib_r(b, a+b, n-1);
}

public static int fib (int n) {
    return fib_r(0, 1, (n > 0) ? n : 1);
}