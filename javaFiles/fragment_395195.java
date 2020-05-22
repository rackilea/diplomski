private boolean isUnderAttack(int row, int column) {
// check column
for (int i=0; i<row-1; i++){
    /* add a check to ensure the column offset index is valid */
    if (column - 1 >= 0 && board[i][column-1]==1){
        return true;
    }
}
// check row
for (int i=0; i<column-1; i++) {
    /* add a check to ensure the row offset index is valid */
    if (row - 1 >= 0 && board[row-1][i] == 1){
        return true;
    }
}