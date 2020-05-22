public static boolean allLess(int[] a, int[] b) {
    if (a.length == b.length) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= b[i]) {
                return false;
            }
        }
    } else {
        return false;
    }
    return true;
}