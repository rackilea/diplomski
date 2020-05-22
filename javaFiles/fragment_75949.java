public static boolean allLess(int[] a, int[] b) {
    boolean sameLength = (a.length == b.length);
    if (!sameLength)
        return false;
    boolean digitDifference = true;
    for (int i = 0; i <= a.length - 1 && digitDifference; i++) {
        digitDifference = (a[i] < b[i]);
    }
    return digitDifference;
}