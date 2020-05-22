static void calculateRegion(int[][] regions, int i, int j) {
    regions[i][j] = onePercentIncrease(regions[i][j]);
    if (i > 0) {
        regions[i][j] += onePercentIncrease(regions[i - 1][j]) - regions[i - 1][j];
    }
    if (i + 1 < regions.length) {
        regions[i][j] += onePercentIncrease(regions[i + 1][j]) - regions[i + 1][j];
    }
}