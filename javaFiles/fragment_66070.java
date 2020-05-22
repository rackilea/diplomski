public int determinant(int[][] result, int rows, int cols) {
    if (rows == 2)
        return result[0][0] * result[1][1] - result[0][1] * result[1][0];

    int determinant1 = 0, determinant2 = 0;
    for (int i = 0; i < rows; i++) {
        int temp = 1, temp2 = 1;
        for (int j = 0; j < cols; j++) {
            temp *= result[(i + j) % cols][j];
            temp2 *= result[(i + j) % cols][rows - 1 - j];
        }

        determinant1 += temp;
        determinant2 += temp2;
    }

    return determinant1 - determinant2;
}