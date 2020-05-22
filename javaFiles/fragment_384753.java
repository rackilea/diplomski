public static boolean diagonals(char[][] b, int row, int col, int l) {

            int counter = 1; // because we start from the current position
            char charAtPosition = b[row][col];
            int numRows = b.length;
            int numCols = b[0].length;
            int topleft = 0;
            int topright = 0;
            int bottomleft = 0;
            int bottomright = 0;
            for (int i=row-1,j=col-1;i>=0 && j>=0;i--,j--) {
                if (b[i][j]==charAtPosition) {
                    topleft++;
                } else {
                    break;
                }
            }
            for (int i=row-1,j=col+1;i>=0 && j<=numCols;i--,j++) {
                if (b[i][j]==charAtPosition) {
                    topright++;
                } else {
                    break;
                }
            }
            for (int i=row+1,j=col-1;i<=numRows && j>=0;i++,j--) {
                if (b[i][j]==charAtPosition) {
                    bottomleft++;
                } else {
                    break;
                }
            }
            for (int i=row+1,j=col+1;i<=numRows && j<=numCols;i++,j++) {
                if (b[i][j]==charAtPosition) {
                    bottomright++;
                } else {
                    break;
                }
            }
            return topleft + bottomright + 1 >= l || topright + bottomleft + 1 >= l; //in this case l is 5
    }