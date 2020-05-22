public Matrix imageFilterAverage() {
    Matrix newMatrix = new Matrix(_matrix);
    for (int i=0; i < _matrix.length;i++)
        for (int j=0; i < _matrix[i].length;j++)
            newMatrix._matrix[i][j] =  _matrix[i-1][j-1] + _matrix[i-1][j] + _matrix[i-1][j+1] + _matrix[i][j-1] + _matrix[i][j] + _matrix[i][j+1] + _matrix[i+1][j-1] + _matrix[i+1][j] + _matrix[i+1][j+1];
    return newMatrix;
}