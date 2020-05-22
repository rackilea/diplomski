public static boolean s(int a, int b) {
    if (b == 0) {
        return (a > 9 && a < 21);
    }
    return (a > 9 && a < 21) || s(b, 0);
}