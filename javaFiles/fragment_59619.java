for (int i = 0; i < mat1.length - 1; i++) {
            for (int j = 0; j <= mat1[i].length - 1; j++) {
                norm[i][j] = (mat1[i][j] - min_bound[0][j]
                        / (max_bound[0][j] - min_bound[0][j]));// error in this
                // line
            }
        }