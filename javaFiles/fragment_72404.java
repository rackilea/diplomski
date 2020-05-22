public void swap() {
    int up = 0; //Can be replaced with variable 'i' in loop
    int down = matrix.length - 1;
    for(int i = 0; i < matrix.length; i++) {
        int left = 0; //Can be replaced with variable 'j' in loop
        int right = matrix[i].length - 1;
        for(int j = 0; j < matrix[i].length / 2; j++) {
            int temp = matrix[i][left];
            matrix[i][left] = matrix[i][right];
            matrix[i][right] = temp;
            left++;
            right--;
        }
    }
    for(int i = 0; i < matrix.length / 2; i++) {
        int[] temp = matrix[up];
        matrix[up] = matrix[down];
        matrix[down] = temp;
        up++;
        down--;
    }
}