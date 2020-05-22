for (int k = 0; k <= 2 * (array.length - 1); ++k) {
    for (int y = 0; y < array.length; ++y) {
        int x = k - y;
        if (x < 0 || x >= array.length) {
            // Coordinates are out of bounds; skip.
        } else {
            System.out.print(array[y][x]);
        }
    }
    System.out.println();
}