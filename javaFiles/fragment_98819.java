int newArray[] = new int[matrix.length*matrix[0].length];
    for(int i = 0; i < matrix.length; i++) {
        int[] row = matrix[i];
        for(int j = 0; j < row.length; j++) {
            int number = matrix[i][j];
            newArray[i*row.length+j] = number;
        }
    }