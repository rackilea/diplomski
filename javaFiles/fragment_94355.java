public boolean check(int row, int col, String word, char[][] puzzle) {
    if(checkRight(row, col, word, puzzle)) return true;
    if(checkLeft(row, col, word, puzzle)) return true;
    if(checkUp(row, col, word, puzzle)) return true;
    if(checkDown(row, col, word, puzzle)) return true;
    if(checkDiagonals(row, col, word, puzzle)) return true;
    return false;
}