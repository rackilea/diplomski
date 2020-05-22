public int[][] cofactor(int[][] matrix, int rows, int cols) {
    int[][] result = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            result[i][j] = (int) (Math.pow(-1, i + j) * determinant(
                    removeRowCol(matrix, rows, cols, i, j), rows - 1,
                    cols - 1));
        }
    }

    return result;
}

public int[][] removeRowCol(int[][] matrix, int rows, int cols,
        int row, int col) {
    int[][] result = new int[rows - 1][cols - 1];

    int k = 0, l = 0;
    for (int i = 0; i < rows; i++) {
        if (i == row)
            continue;
        for (int j = 0; j < cols; j++) {
            if (j == col)
                continue;
            result[l][k] = matrix[i][j];

            k = (k + 1) % (rows - 1);
            if (k == 0)
                l++;
        }
    }

    return result;
}