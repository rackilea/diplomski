public class Main {

    final static int row = 15;
    final static int column = 15;
    final static int win_count = 5;

    public static void main(String[] args) {

        boolean[][] board1 = new boolean[row][column];
        boolean[][] board2 = new boolean[row][column];
        /*
         * for each change by player1 in (i,j) in the board. (index start from 0
         * to 14)
         */
        int i = 2;
        int j = 3;
        Boolean win = checkWin(board1, i, j);
        System.out.println("player1 win=" + win);
    }

    private static Boolean checkWin(boolean[][] board1, int i, int j) {
        /**
         * 1) check horizontal
         */
        int leftBound = 0;
        if (j - win_count >= 0)
            leftBound = j - win_count;
        else
            leftBound = 0;

        int rightBound = 0;
        if (j + win_count < column)
            rightBound = j + win_count;
        else
            rightBound = column - 1;

        int hitCount = 0;
        int jk = j;

        // go left
        while (jk >= leftBound && hitCount < win_count) {
            if (board1[i][jk]) {
                hitCount++;
                jk--;
            } else {
                jk = j;
                break;
            }
        }
        // go right

        while (jk <= rightBound && hitCount < win_count) {
            if (board1[i][jk]) {
                hitCount++;
                jk++;
            } else {
                break;
            }
        }

        if (hitCount >= win_count)
            return true;

        /**
         * 2) check vertical
         */

        /**
         * 3) check principal diagonal 
         */

        /**
         * 4) check minor diagonal
         */

        // otherwise:

        return false;
    }

}