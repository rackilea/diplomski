// create matrix A
double[][] matValues = new double[n][n];
... // initialize values of the matrix
Matrix A = new DenseMatrix(matValues);

// create vector x
double[] vecValues = new double[n];
... // initialize values of the vector
Vector x = new DenseVector(vecValues);

// create vector y to store result of multiplication
Vector y = new DenseVector(n);

// perform multiplication
A.mult(x, y);