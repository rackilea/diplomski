/*
 * Return true if space is ok to use.
 */
public boolean isMoveOK(Cell cell) {
    return board[cell.x][cell.y] == 0;
}