public String toString() {
    String strMatrix = null;
    String strRow = null;
    String strElement = null;

    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[i].length; j++) {
            strElement = String.valueOf(matrix[i][j]);
            strRow = strRow + strElement + "\t";
        }
        strMatrix =  strMatrix + strRow + "\n";
    }
    return strMatrix;
}