Random r = new Random();
 for (int i = 0; i < mines; i++) {
    int randRow = r.nextInt(width);
    int randColumn = r.nextInt(height);
    while (board[randRow][randColumn] == Square.MINE) {
        randRow = r.nextInt(width);
        randColumn = r.nextInt(height);
        // Don't do anything here !!!
    }
    // Now that you found an empty spot, put a mine
    board[randRow][randColumn] = Square.MINE;
}