public static int max1020(int a, int b) {
    boolean aRange = a >= 10 && a <= 20, bRange = b >= 10 && b <= 20;
    if (aRange && bRange) {
        return Math.max(a, b);
    } else if (!aRange && bRange) {
        return b;
    } else if (aRange) { // !bRange implied by last two tests
        return a;
    }
    return 0;
}