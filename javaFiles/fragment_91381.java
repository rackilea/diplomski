// return C = A * B
public Matrix times(Matrix B) {
    Matrix A = this;
    if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions.");
    Matrix C = new Matrix(A.M, B.N);
    for (int i = 0; i < C.M; i++) {
        for (int j = 0; j < C.N; j++) {
            for (int k = 0; k < A.N; k++) {
                C.content[i][j] += (A.content[i][k] * B.content[k][j]);
            }
        }
    }
    return C;
}