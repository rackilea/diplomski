for (int i = 0; i < mines; i++) {
    int randRow = (int) (Math.random() * width);
    int randColumn = (int) (Math.random() * height);
    while (board[randRow][randColumn] == Square.MINE) {
        randRow = (int) (Math.random() * width);
        randColumn = (int) (Math.random() * height);
        board[randRow][randColumn] = Square.MINE;
    }
    board[randRow][randColumn] = Square.MINE;
}