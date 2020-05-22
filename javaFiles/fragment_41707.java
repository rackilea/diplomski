public double[][] transpose( double[][] oldMatrix ){
    int size = 3;
    double[][] newMatrix = new double[size][size];
    for (int i = 0; i < size; i++){
        for (int j = 0; j < size; j++){
            newMatrix[j][i] = oldMatrix[i][j];
        }
    }
    return newMatrix;
}