for (i = 0; i < N; i++) {

    for (j = 0; j < N; j++) { 
        c[i][j] = 0;

        for (k = 0; k < N; k++) {
            c[i][j] += a[i][k] * b[k][j]; // C matrix calculated from a and B matrices.
        }

        pool.submit(new Multi(N,i,j,a,b,c));
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.DAYS);
    }
}