if ( !hubIsClicked && !touchMoveIsDone)
{
  if (event.isActionDown())
  {  
    System.out.println("isActionDown, puzzlepiece");
    touchMoveIsDone = false;
    touchedBoardBlock = getBoardBlockFromPixelCoordinate(X, Y);
  }
  else if (event.isActionMove())
  {
    // Puzzle piece
    System.out.println("isActionMove, puzzlepiece");
    ..
  }
}