public class Block
{    
  private List<Cell> cells = new ArrayList<Cell>();

      public boolean canMerge(Cell cell)
      {
        if (cells.isEmpty())
        {
          return true;
        }
        else
        {
          for (Cell existingCell : cells)
          {
            if (existingCell.isAdjacent(cell))
            {
              return true;
            }
          }
        }
        return false;
      }

      public void merge(Cell cell)
      {
        cells.add(cell);
      }

      public void merge(Block block)
      {
        cells.addAll(block.getCells());
      }

      public List<Cell> getCells()
      {
        return cells;
      }
}