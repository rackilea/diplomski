for (int k = 0; k <= 2 * (array.length - 1); ++k) {
    int yMin = Math.max(0, k - array.length + 1);
    int yMax = Math.min(array.length - 1, k);
    for (int y = yMin; y <= yMax; ++y) {
        int x = k - y;
        System.out.print(array[y][x]);
    }
    System.out.println();
}