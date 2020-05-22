for (long j = 0, limit = 1<<(dim*dim); j < limit; j++) { //for each possible matrix
    int[][] matrix = new int[dim][dim];//make a 2d i*i matrix

    //fill matrix
    for (int k = 0, counter = 0; k < dim; k++) {//for each row
        for (int l = 0; l < dim; l++, counter++) {//for each column
            matrix[k][l] = (j >>> counter) & 1;
        }
    }