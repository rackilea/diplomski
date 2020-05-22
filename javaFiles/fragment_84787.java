class Cell
{

  // other codes

  public boolean isAdjacent(Cell cell)
  {
    int xDiff = cell.getX() - x;
    int yDiff = cell.getY() -y;
    if(xDiff>=-1 && xDiff<=1 && yDiff>=-1 && yDiff<=1)
    {
       return true;
    }
    return false;

  }
}