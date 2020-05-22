int[][] m = {{1, 2, 3, 4}, {3, 4, 5, 1}, {1, 2, 0, 1}};

    int[][] rowMatrix = new int[m.length][m[0].length];
    int[][] colMatrix = new int[m.length][m[0].length];

    for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m[0].length; j++) {

            if (j == 0) rowMatrix[i][j] = m[i][j]; 
            else        rowMatrix[i][j] = m[i][j] + rowMatrix[i][j - 1];

            if (i == 0) colMatrix[i][j] = m[i][j];
            else        colMatrix[i][j] = m[i][j] + colMatrix[i - 1][j];

        }
    }