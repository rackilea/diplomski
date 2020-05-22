public static int[][] blocks(int[][] matrix, int sqrtN) {
    int n = matrix.length;
    if (n != Math.pow(sqrtN, 2))
        throw new RuntimeException("Matrix length is not" + Math.pow(sqrtN, 2));
    int[][] returnedMatrix = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int r = (i/sqrtN)*sqrtN+j/sqrtN;
            int c = (i%sqrtN)*sqrtN+j%sqrtN;
            returnedMatrix[i][j] = matrix[r][c];
        }
    }
    return returnedMatrix;
}

public static void print(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }
    System.out.println();
}

public static void main(String args[]) {
    int[][] matrix4 = {
        {1,1,2,2},
        {1,1,2,2},
        {3,3,4,4},
        {3,3,4,4}
    };
    print(blocks(matrix4, 2));

    int[][] matrix9 = {
        {1,1,1,2,2,2,3,3,3},
        {1,1,1,2,2,2,3,3,3},
        {1,1,1,2,2,2,3,3,3},
        {4,4,4,5,5,5,6,6,6},
        {4,4,4,5,5,5,6,6,6},
        {4,4,4,5,5,5,6,6,6},
        {7,7,7,8,8,8,9,9,9},
        {7,7,7,8,8,8,9,9,9},
        {7,7,7,8,8,8,9,9,9}
    };
    print(blocks(matrix9, 3));
}