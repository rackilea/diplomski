static double[][] matrixPow(double[][] matrixA, int e) {

 //Einheitsmatrix
 if (e == 0) {
  double[][] I = new double[matrixA[0].length][matrixA.length];
  for (int k = 0; k < matrixA.length; k++) {
   I[k][k] = 1;
  }
  return I;
 }
 //Der eine Kram
 else if ((e % 2) == 0) {
  return matrixPow(matrixMult(matrixA, matrixA), e / 2);
 }
 //der andere Kram
 else if ((e % 2) == 1) {
  return matrixMult(matrixA, matrixPow(matrixA, (e - 1)));
 }
 // we return null in case every other cases fails.
 return null
}