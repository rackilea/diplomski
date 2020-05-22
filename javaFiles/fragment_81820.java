Cell userMove = new Cell(y, x);

if (grid.isMoveOK(userMove)) {
    grid.placeAMove(userMove, 2); // 2 for O and O is the user
} else {
    System.out.println("Please try a different space/cell");
    continue;
}

grid.displayBoard();
if (grid.gameOver())
    break;