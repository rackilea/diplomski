boolean sudoku(int[][] grid) {
    for (int i = 0; i <9; i++) {
        int row = 0, col = 0, group = 0;
        for (int j = 0; j <9; j++) {
            // check for row i
            row += grid[i][j];

            // check for col i
            col += grid[j][i];

            // check for sub-grid i
            group += grid[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3];
        }

        if (row != 45 || col != 45 || group != 45)  return false;
    }

    return true;
}