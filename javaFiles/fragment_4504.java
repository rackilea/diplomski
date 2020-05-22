package ch7;

public class Chapter_07_E22_EightQueens {

    static final int N = 8;

    public static void main(String[] args) {

        int[] queens = new int[N];
        int attempts = 0;

        for (int i = 0; i < N; i++) 
            queens[i] = i;

        while (checkBoardForCollision(queens)) {
            shuffleBoard(queens);
            attempts++;
        }
        printBoard(queens);
        System.out.println("Solution found in " + attempts + " attempts");
    }

    public static void printBoard(int[] queens) {

        for (int row = 0; row < N; row++) {
            System.out.printf("%-1c", '|');
            for (int column = 0; column < N; column++) {
                System.out.printf("%-1c|", (queens[row] == column) ? 'Q' : ' ');
            }
            System.out.println();
        }       
    }

    public static boolean shareDiagonal(int x0, int y0, int x1, int y1) {

        int dy = Math.abs(y1 - y0);
        int dx = Math.abs(x1 - x0);

        return dx == dy;
    }

    public static boolean checkRowForCollision(int[] queens, int row) {

        for (int i = 0; i < row; i++) {

            if (shareDiagonal(i, queens[i], row, queens[row]))
                return true;    
        }
        return false;
    }

    public static boolean checkBoardForCollision(int[] queens) {

        for (int row = 0; row < queens.length; row++)
            if (checkRowForCollision(queens, row))
                return true;

        return false;
    }

    public static int[] shuffleBoard(int[] queens) {

        for (int i = queens.length - 1;  i > 0; i--) {

            int j = (int)(Math.random() * (i + 1));

            int temp = queens[i];
            queens[i] = queens[j];
            queens[j] = temp;
        }
        return queens;
    }
}