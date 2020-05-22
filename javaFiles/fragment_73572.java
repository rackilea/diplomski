public String[][] getBoard() {
    String[][] board = new String[9][9];

    for(int i=0 ; i<9;i++){
        for(int j=0 ; j<9; j++){
            board[i][j] = microboardArray[i][j].toString();
        }
    }
    return board;
    }