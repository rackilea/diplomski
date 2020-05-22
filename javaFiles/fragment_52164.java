int boxSums[][] = new int[3][3],
        rowSums[] = new int[9],
        columnSums[] = new int[9];
for (int i = 0; i < 9; i++) {
    for (int j = 0; j < 9; j++) {
        int value = grid[i][j];
        boxSums[i / 3][j / 3] += value;
        rowSums[i] += value;
        columnSums[j] += value;
    }
}