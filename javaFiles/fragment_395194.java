private void setQueen(int row, int column) {
    if(row - 1 < BOARD_SIZE && column - 1 < BOARD_SIZE)
        board[row-1][column-1] = QUEEN;
} // end setQueen

private void removeQueen(int row, int column) {
   if(row - 1 < BOARD_SIZE && column - 1 < BOARD_SIZE)
       board[row-1][column-1] = EMPTY;
} // end setQueen