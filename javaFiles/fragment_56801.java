static ArrayList<Case> listFromBoard() {
    ArrayList<Case> myList = new ArrayList<Case>();
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            int valeur = Sudoku.board[i][j];
            if (valuer != 0) myList.add(new Case(i+1,j+1,valeur);
        }
    }
}