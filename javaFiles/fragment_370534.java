public boolean hasLegalMoveFor(boolean player) {
    int rowInc = 0;
    int colInc = 0;
    if(player == HORIZONTAL) {
        colInc = 1;
    } else {
        rowInc = 1;
    }
    for(int row = 0; row < (squares.length - 2*rowInc); row++) {
        for(int column = 0; column < (squares[0].length - 2*colInc); column++) {
            if (!(squares[row][column] || squares[row + rowInc][column + colInc] || squares[row + 2*rowInc][column + 2*colInc])) {
                return true;
            }
        }
    }
    return false;
}