public class MagicSquare {

    private int[][] magicSquare;
    private boolean[] available;

    public MagicSquare() {
        magicSquare = new int[3][3];
        available = new boolean[9];
        for (int i = 0; i < available.length; i++) {
            available[i] = true;
        }
    }

    public void run() {
        System.out.println("Magic Square Puzzle");
        solve(0, 0);
    }

    public void solve(int row, int col) {
    for (int i = 1; i <= 9; i++) {
        if (isAvailable(i)) {
            //System.out.println("placing " + i + " at (" + row + ", " + col + ")");
            magicSquare[row][col] = i;
            available[i - 1] = false;
            //solution is valid so far
            if (isFilled()) {
                if (isValidSolution()) {
                    System.out.println("You found a correct solution!");
                    printSolution();
                }
            } else {
                if (col != 2) {
                    //System.out.println("new col and solve(" + row + ", " + col + ")");
                    solve(row, col + 1);
                } else if (row != 2) {
                    //System.out.println("new row and solve(" + row + ", " + col + ")");
                    solve(row + 1, 0);
                    //new col    
                }
            }
            magicSquare[row][col] = 0;
            available[i - 1] = true;
        }
    }
}

    public boolean isAvailable(int value) {
        if (available[value - 1] == true) {
            //System.out.println(value + " is available to be placed");
            return true;
        } else {
            //System.out.println(value + " is not available to be placed");
            return false;
        }
    }

    public boolean isValidRow(int row) {
        if (magicSquare[row][0] + magicSquare[row][1] + magicSquare[row][2] == 15) {
            //System.out.println("row " + row + " adds to 15");
            return true;
        } else {
            //System.out.println("row " + row + " does not add to 15");
            return false;
        }
    }

    public boolean isValidCol(int col) {
        if (magicSquare[0][col] + magicSquare[1][col] + magicSquare[2][col] == 15) {
            //System.out.println("col " + col + " adds to 15");
            return true;
        } else {
            //System.out.println("col " + col + " does not add to 15");
            return false;
        }
    }

    public boolean isValidOnDiagonals() {
        if ((magicSquare[0][0] + magicSquare[1][1] + magicSquare[2][2] == 15) && (magicSquare[2][0] + magicSquare[1][1] + magicSquare[0][2] == 15)) {
            //System.out.println("diagonals add to 15");
            return true;
        } else {
            //System.out.println("diagonals don't add to 15");
            return false;
        }
    }

    public boolean isValidSolution() {
        for (int i = 0; i < magicSquare.length; i++) {
            if (!isValidRow(i) || !isValidCol(i)) {
                //System.out.println("solution is valid");
                return false;
            }
        }
        //System.out.println("solution is not valid");
        return isValidOnDiagonals();
    }

    public boolean isFilled() {
        for (int i = 0; i < available.length; i++) {
            if (available[i]) {
                return false;
            }
        }
        return true;
    }

    public void printSolution() {
        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare[i].length; j++) {
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }
    }
}