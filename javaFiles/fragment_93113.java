public static void reverseColumnsInPlace(int[][] matrix){
        for(int col = 0;col < matrix[0].length; col++){
            for(int row = 0; row < matrix.length/2; row++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[matrix.length - row - 1][col];
                matrix[matrix.length - row - 1][col] = temp;
            }
    }
}

public static void reverseRowsInPlace(int[][] matrix){

    for(int row = 0; row < matrix.length; row++){
        for(int col = 0; col < matrix[row].length / 2; col++) {
            int temp = matrix[row][col];
            matrix[row][col] = matrix[row][matrix[row].length - col - 1];
            matrix[row][matrix[row].length - col - 1] = temp;
        }
    }
}