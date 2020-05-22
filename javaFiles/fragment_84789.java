public class GameStatus
{
  HashMap<Integer,List<Block>> players = new HashMap<Integer, List<Block>>();

  public boolean markCell(Cell cell,int player)
  {
    int count = 0;
    List<Block> blocks = players.get(player);
    if(blocks==null)
    {
      // this is the first cell mark by this player
      blocks = new ArrayList<Block>();
      Block block = new Block();
      block.merge(cell);
      blocks.add(block);
      players.put(player,blocks);
    }
    else
    {
      Block alreadyMergedToThisBlock = null;
      ArrayList<Block> shouldBeRemovedList = new ArrayList<Block>();
      for (Block block : blocks)
      {
        if(block.canMerge(cell)) // cell is adjacent to a block
        {
          if (alreadyMergedToThisBlock==null) // this is the first block we found which is adjacent to the given cell
          {
            block.merge(cell);
            count = block.getCells().size();
            alreadyMergedToThisBlock = block;
          }
          else
          {
            // we have already merge given cell to block,but this block also adjacent to the given cell.
            // that means two blocks can be merged together and this block can be removed once it is merged to the previous one
            alreadyMergedToThisBlock.merge(block); 
            count = alreadyMergedToThisBlock.getCells().size();
            shouldBeRemovedList.add(block);
          }
        }
      }
      blocks.removeAll(shouldBeRemovedList);
    }

    return count>=9;

  }
}