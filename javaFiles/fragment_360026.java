public class MAZE {

    static int x, y;
    static boolean result = false;

    public static void main(String[] args) {
        int [][] matrix =new int[5][];// fill your array
        // fill x and y
        // x= cheese x value
        // y = cheese y value
        isPath(matrix, x, x);
        // print result


    }

    static void isPath(int[][] matrix, int i, int j) {
        if (i - 1 > -1 && matrix[i - 1][j] == 1) {
            // subarray1 = copy starting from [0][0] to matrix[i-1][j]
            // checkSPath(subarray1,i-1,j);
        }
        if (j - 1 > -1 &&  matrix[i][j - 1] == 1) {
            // subarray1 = copy starting from [0][0] to matrix[i][j-1]
            // checkLPath(subarray1,i,j-1);
        }

        if (i + 1 < x && matrix[i + 1][j] == 1) {
            // subarray1 = copy starting from [0][0] to matrix[i+1][j]
            // checkNPath(subarray1,i+1,j);
        }
        if (j + 1 < y &&  matrix[i][j + 1] == 1) {
            // subarray1 = copy starting from [0][0] to matrix[i][j+1]
            // checkRPath(subarray1,i,j+1);
        }
    }

    static void checkRPath(int[][] matrix, int i, int j) {
        if (i == 0 && j == 0) {
            result = true;
        } else {
            if (i - 1 > -1 && matrix[i - 1][j] == 1) {
                // subarray1 = copy starting from [0][0] to matrix[i-1][j]
                // checkSPath(subarray1,i-1,j);
            }

            if (i + 1 < x && matrix[i + 1][j] == 1) {
                // subarray1 = copy starting from [0][0] to matrix[i+1][j]
                // checkNPath(subarray1,i+1,j);
            }
            if (j + 1 < y && matrix[i][j + 1] == 1) {
                // subarray1 = copy starting from [0][0] to matrix[i][j+1]
                // checkRPath(subarray1,i,j+1);
            }
        }
    }

    static void checkLPath(int[][] matrix, int i, int j) {

        if (i == 0 && j == 0) {
            result = true;
        } else {
            if (i - 1 > -1 && matrix[i - 1][j] == 1) {
                // subarray1 = copy starting from [0][0] to matrix[i-1][j]
                // checkSPath(subarray1,i-1,j);
            }
            if (j - 1 > -1 && matrix[i][j - 1] == 1) {
                // subarray1 = copy starting from [0][0] to matrix[i][j-1]
                // checkLPath(subarray1,i,j-1);
            }

            if (i + 1 < x && matrix[i + 1][j] == 1) {
                // subarray1 = copy starting from [0][0] to matrix[i+1][j]
                // checkNPath(subarray1,i+1,j);
            }
        }
    }

    static void checkNPath(int[][] matrix, int i, int j) {
        if (i == 0 && j == 0) {
            result = true;
        } else {
            if (j - 1 > -1 && matrix[i][j - 1] == 1) {
                // subarray1 = copy starting from [0][0] to matrix[i][j-1]
                // checkLPath(subarray1,i,j-1);
            }

            if (i + 1 < x && matrix[i + 1][j] == 1) {
                // subarray1 = copy starting from [0][0] to matrix[i+1][j]
                // checkNPath(subarray1,i+1,j);
            }
            if (j + 1 < y && matrix[i][j + 1] == 1) {
                // subarray1 = copy starting from [0][0] to matrix[i][j+1]
                // checkRPath(subarray1,i,j+1);
            }
        }

    }

    static void checkSPath(int[][] matrix, int i, int j) {
        if (i == 0 && j == 0) {
            result = true;
        } else {
            if (i - 1 > -1 && matrix[i - 1][j] == 1) {
                // subarray1 = copy starting from [0][0] to matrix[i-1][j]
                // checkSPath(subarray1,i-1,j);
            }
            if (j - 1 > -1 && matrix[i][j - 1] == 1) {
                // subarray1 = copy starting from [0][0] to matrix[i][j-1]
                // checkLPath(subarray1);
            }

            if (j + 1 < y && matrix[i][j + 1] == 1) {
                // subarray1 = copy starting from [0][0] to matrix[i][j+1]
                // checkRPath(subarray1);
            }
        }
    }
}