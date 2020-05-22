public static int diagSumTwo() {
    int sum = 0;
    for (int r = 0; r < grid.length; r++) {
        sum += grid[r][r];
    }
    return sum;
}

public static int diagSumOne() {
    int sum = 0;
    for (int r = grid.length - 1; r >= 0; r--) {
        sum += grid[r][grid.length - 1 - r];
    }
    return sum;
}