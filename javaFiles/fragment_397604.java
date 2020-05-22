public Board makeMove(int move) {
    int[] newBoard = new int[board.length];
    System.arraycopy(board, 0, newBoard, 0, board.length);

    newBoard[currentPlayer] |= map[move];
    return new Board(newBoard, opponent);
}