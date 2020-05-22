static void insertCaseToBoard(Case case) {
    Sudoku.board[case.ligne-1][case.colone-1] = case.valeur;
}

static void removeCaseFromBoard(int ligne, int colone) {
    Sudoku.board[ligne-1][colone-1] = 0;
}

static void clearBoard() {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            Sudoku.board[i][j] = 0;
        }
    }
}