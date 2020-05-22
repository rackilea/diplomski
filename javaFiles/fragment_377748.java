int multiplication[][] = new int[rows][otherMatrix.columns];
for(int r = 0; r < rows; r++) {
    for(int c = 0; c < otherMatrix.columns; c++) {
        int sum = 0;
        for(int i = 0; i < otherMatrix.columns; i++)
            sum += matrix[r][i]*otherMatrix.matrix[i][c];
        multiplication[r][c] = sum;
    }