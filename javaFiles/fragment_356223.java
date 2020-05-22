public void AIMove() {
    int[] generatedMove = aiPlayer.move();
    board.cells[generatedMove[0]][generatedMove[1]].content = currentPlayer;
    updateGame(currentPlayer, generatedMove[0], generatexMove[1]);
    repaint();
}