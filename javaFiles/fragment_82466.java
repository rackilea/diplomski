public boolean checkDiagonals(String b) {
    /* Check the diagonals starting in every position */
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if (checkDiagonalForWin(b, i, j) || checkOtherDiagonalForWin(b, i, j)) {
                return true;
            }
        }
    }
    return false;
}