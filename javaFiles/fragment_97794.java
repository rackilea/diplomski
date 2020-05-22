private static boolean isWay(int[] a, int i) {
    if (i == a.length)
        return true;
    if (i < 0 || i > a.length) // just check here
        return false;
    if (a[i] == 0)
        return false;
    int temp = a[i];
    a[i] = 0;
    return (isWay(a, i + temp)) || isWay(a, i - temp);
}