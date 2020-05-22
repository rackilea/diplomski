// The point coordinates of each point in each possible winning line.
static final int[][][] LINES = {
        {{0, 0}, {0, 1}, {0, 2}},
        {{1, 0}, {1, 1}, {1, 2}},
        {{2, 0}, {2, 1}, {2, 2}},
        {{0, 0}, {1, 0}, {2, 0}},
        {{0, 1}, {1, 1}, {2, 1}},
        {{0, 2}, {1, 2}, {2, 2}},
        {{0, 0}, {1, 1}, {2, 2}},
        {{2, 0}, {1, 1}, {0, 2}},
};
// The players.
static final int PLAYER1 = 1;
static final int PLAYER2 = -1;

private int checkWin(int[][] board) {
    // Check each line.
    for (int[][] line : LINES) {
        // Add up the total value of each line.
        int total = 0;
        for (int[] point : line) {
            // Use the point to specify which square on the board to check.
            total += board[point[0]][point[1]];
        }
        // If the total adds up to 3 or -3 then someone has won on this line.
        if (total == line.length * PLAYER1) {
            return PLAYER1;
        }
        if (total == line.length * PLAYER2) {
            return PLAYER2;
        }
    }
    // Nobody won.
    return 0;
}

public void test(String[] args) {
    int[][] board = new int[3][];
    for ( int i = 0; i < board.length; i++) {
        board[i] = new int[3];
    }
    // Set up a win..
    board[0][0] = PLAYER1;
    board[1][1] = PLAYER1;
    board[2][2] = PLAYER1;
    int winner = checkWin(board);
    System.out.println(winner);
}