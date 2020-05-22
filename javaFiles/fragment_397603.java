public Board makeMove(int move) {
    int[] newBoard = board;
    //               ^^^^^
    newBoard[currentPlayer] |= map[move];
    return new Board(newBoard, opponent);
}