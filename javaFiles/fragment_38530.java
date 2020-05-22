private static void next(int [][] matrica2,int row, int col) {
if (col  8) {
    resi(matrica2,row, col + 1);
} else if(row < 8) { // Make sure to increment row only if less than 8
    resi(matrica2,row + 1, 0);
} else {
    // Stop the application (May Be)
 }