public void isSymmetricNow(int[][] matrix){
    //Random random = new Random();
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length; j++) {
            //matrix[i][j] = random.nextInt(20);
            if (matrix[i][j] != matrix[j][i]) {
                System.out.print("matrix is not symmetric \n");
                return;
            }
        }
    }
    System.out.print("matrix is symmetric \n");
}