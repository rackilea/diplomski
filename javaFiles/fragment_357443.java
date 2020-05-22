void schedule(int n) {
    if (n > 0) {
        schedule(n/2);
        if (n == 1)
            A[0][0] = 1;
        else {
            for (int r = 0; r < n/2; r++)
                for (int c = 0; c < n/2; c++) {
                    A[r][c+(n/2)] = A[r][c] + (n/2);
                    A[r+(n/2)][c] = A[r][c] + (n/2);
                    A[r+(n/2)][c+(n/2)] = A[r][c];
                }
        }
    }
}