private static boolean backtrack(int[] board, int cell, int value) {
    int line = cell / 9;
    //check line
    for (int i = 0; i < 9; i++) {
        if ((board[line * 9 + i] == value)) {
            return true;
        }
    }

    int column = cell % 9;
    //check column
    for (int i = 0; i < 9; i++) {
        if (board[column + i * 9] == value) {
            return true;
        }
    }

    int squareLine = line - (line % 3);
    int squareColumn = column - (column % 3);
    //check square
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[(squareLine + i) * 9 + (squareColumn + j)] == value) {
                return true;
            }
        }
    }

    return false;
}