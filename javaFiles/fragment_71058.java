for (int k = 0; k < n; k++) {
        int temp = A[i][k];  
        for (int j = 0; j < n; j++) {
            C[i][j] += temp * B[k][j];
        }
    }