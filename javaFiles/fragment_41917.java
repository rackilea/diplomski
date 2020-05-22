public int[][] getQuadrantOfSquareMatrix(int[][] matrix) {
    int newDimension = matrix.length / 2;
    int[][] toReturn = new int[newDimension][newDimension];
    for (int i = 0; i < newDimension; i++) {
        for (int j = 0; j < newDimension; j++) {
            toReturn[i][j] = matrix[i + newDimension][j + newDimension];
        }
    }
    return toReturn;
}