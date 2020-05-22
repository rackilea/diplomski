public static void fillTotals(int[][] scores) {
    for (int c=0; c < scores[0].length; ++c) {
        int sum = 0;
        for (int r=0; r < scores.length - 1; ++r) {
            sum += scores[r][c];
        }
        scores[scores.length - 1][c] = sum;
    }
}