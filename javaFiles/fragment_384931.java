public static double sqrtR (long x, double e, double a) {

    if (Math.abs(a * a - x) <= e) {
        return a;
    } else {
        a = (a * a + x) / (2 * a);
        return 1.0 *(sqrtR(x, e, a));
    }
}