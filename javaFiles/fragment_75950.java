public static boolean allLess(int[] a, int[] b) {
    if (a.length != b.length)
        return false;
    for (int i = 0; i <= a.length - 1; i++) {
        if (a[i] >= b[i])
            return false;
    }
    return true;
}