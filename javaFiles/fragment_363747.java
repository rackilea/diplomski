public static float aritmetickyPrumerSloupce(int[][] a, int column) {
    int sum = 0;
    for (int i = 0; i < a.length; i++)
        sum += a[i][column];
    return sum / (float) a.length;
}