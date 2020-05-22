public String toString() {
    String strMatrix; // once
    String strRow; // once
    String strElement; // once

    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[i].length; j++) {
            String strElement = String.valueOf(matrix[i][j]); // twice
            String strRow = strRow + strElement + "\t"; // twice
        }
        String strMatrix =  strMatrix + strRow + "\n"; // twice
    }
    return strMatrix;
}