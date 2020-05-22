mat[rowA][colA] = 1;
    for (int i = rowA; i <= rowB; i++) {
        for (int j = colA; j <= colB; j++) {
            if (mat[i][j] == 0) { // not a wall?
                // count the number of paths that come from above,
                //   plus the number of paths that come from the left
                mat[i][j] = Math.max(0, mat[i-1][j]) + Math.max(0, mat[i][j-1]);
            }
        }
    }
    return mat[rowB][colB]; // now this has the number of paths we are looking for