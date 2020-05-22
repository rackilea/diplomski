class Move {
    int row, column;

    public Move(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

public void undoMove(int row, int column, int[][] board) {
    board[row][column] = 0;
}