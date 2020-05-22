private void setQueen(int row, int column) {
    if(row < BOARD_SIZE && column < BOARD_SIZE)
        board[row][column] = QUEEN;
} // end setQueen

private void removeQueen(int row, int column) {
   if(row < BOARD_SIZE && column < BOARD_SIZE)
       board[row][column] = EMPTY;
} // end setQueen