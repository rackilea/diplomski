public static void main(String[] args) {
        int matrix1 [][] = matrixGenerator();
        int matrix2 [][] = matrixGenerator();
        int matrix3 [][] = matrixMultiplication(matrix1, matrix2);
        String matrix1Str = Arrays.deepToString(matrix1);
        String matrix2Str = Arrays.deepToString(matrix2);
        String matrix3Str = Arrays.deepToString(matrix3);
        System.out.println(matrix1Str+'\n'+matrix2Str+'\n'+matrix3Str);
    }

    public static int[][] matrixGenerator(){
        int matrix [][] = new int[2][2];
        Random r = new Random( );
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[i].length; j++){
                matrix[i][j] = r.nextInt( 10000 );
            }
        }
        return matrix;
    }

    public static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2) {
        int m1rows = matrix1.length;
        int m1cols = matrix1[0].length;
        int m2cols = matrix2[0].length;

        int[][] result = new int[m1rows][m2cols];
            for (int i=0; i< m1rows; i++){
               for (int j=0; j< m2cols; j++){
                  for (int k=0; k< m1cols; k++){
                     result[i][j] += matrix1[i][k] * matrix2[k][j];
               }
            }
         }
        return result;
    }