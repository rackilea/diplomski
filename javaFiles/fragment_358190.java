public boolean isSymmetricNow(int[][] matrix){
    //Random random = new Random();
     for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix.length; j++) {
            //matrix[i][j] = random.nextInt(20);
            if (matrix[i][j] != matrix[j][i]) {
                return false;
            }
        }
    }
    return true;
}