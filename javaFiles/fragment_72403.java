public void swapMatrixDiagonals() {

    int up = 0; //Can be replaced by variable 'i' in loop
    int down = matrix.length - 1;
    int left = 0; //Can be replaced by variable 'i' in loop
    int right = matrix[matrix.length - 1].length - 1;

    for(int i = 0; i < matrix.length / 2; i++) {
        int tempLeft = matrix[up][left];
        int tempRight = matrix[up][right];

        matrix[up][left] = matrix[down][right];
        matrix[down][right] = tempLeft;

        matrix[up][right] = matrix[down][left];
        matrix[down][left] = tempRight;

        left++;
        right--;
        up++;
        down--;
    }
}