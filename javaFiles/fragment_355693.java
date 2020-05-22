public boolean checkRow(int[] sudokuPuzzle) {
    for (int row = 0; row < sudokuPuzzle.length; row++) {
        for (int i = 0; i < sudokuPuzzle.length; i++) {
            if (i == row) {
                continue;
            }
            if (sudokuPuzzle[i] == sudokuPuzzle[row]) {
                return true;
            }
        }
    }
    return false;
}