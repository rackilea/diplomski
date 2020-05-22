Move lastMove = movement.remove(movement.size() - 1);
playerCol = movement.get(movement.size() - 1).getToCol();
playerRow = movement.get(movement.size() - 1).getToRow();
board[playerRow][playerCol] = PLAYER_CHAR;
if (lastMove.isDoughnutEaten()) {
    int dCol = lastMove.getToCol();
    int dRow = lastMove.getToRow();
    board[dRow][dCol] = DOUGHNUT_CHAR;
    nbrDoughnutsAdded--;
}