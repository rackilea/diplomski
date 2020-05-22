package p1;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the work of finding adjacent blocks.
 * To delete blocks ONLY if the blocks are horizontally adjacent,
 * then you can remove the "Up" and "Down" sections.
 * @author Ted
 */
public class BlockBuster {

    private List<Block> queue;
    private List<Block> bustList;

    /**
     * Creates a new instance of the BlockBuster class.
     */
    public BlockBuster() {
        queue = new ArrayList<Block>();
    }

    /**
     * This method busts the blocks of with matching colors
     */
    public void bustBlocks() {
        Block block = BlockManager.getInstance().getFallingBlock();
        bustList = new ArrayList<Block>();
        queue.add(block);
        while (queue.size() > 0) {
           Block current = queue.get(0);
           addMatchingNeighbors(current);
           queue.remove(0);
           if(!bustList.contains(current)){
                bustList.add(current);
           }

        }
        if(bustList.size() > 2){
          for(Block busted : bustList){
              BlockManager.getInstance().RemoveBlock(busted);
              List<Block> check = BlockManager.getInstance().getAllBlocks();
              if(check.contains(busted)){
                boolean stop = true;
              }
          }
        }
    }

    /**
     * This method adds neighbors that match in color to the queue
     * as long as they don't already exist in the queue or bustlist.
     * @param block The current block to consider.
     */
    private void addMatchingNeighbors(Block block) {
        // currently only check by 4 connectivity
        int x = block.getColumn();
        int y = block.getLevel();
        Color color = block.getColor();

        // left
        Block leftBlock = getBlock(x - 1, y);
        if(colorMatches(color, leftBlock)){
             queue.add(leftBlock);
        }
        // Right
        Block rightBlock = getBlock(x + 1, y);
        if(colorMatches(color, rightBlock)){
            queue.add(rightBlock);

        }
        // Up
        Block upBlock = getBlock(x, y + 1);
        if(colorMatches(color, upBlock)){
            queue.add(upBlock);

        }

        Block downBlock = getBlock(x, y-1);
        if(colorMatches(color, downBlock)){
            queue.add(downBlock);
        }

    }

    /**
     * This tests whether the block's color matches the specified
     * color, and whether or not the block is already in a list.
     * @param color The color that should match for deletion.
     * @param block The block to be removed.
     * @return 
     */
    public boolean colorMatches(Color color, Block block){
       if(block == null){
           return false;
       }
       if(bustList.contains(block)){
           return false;
       }
       if(queue.contains(block)){
           return false;
       }
       return (block.getColor().equals(color));
    }

    /**
     * This finds a block at the specified column and height.
     * @param column The integer column index (0-8)
     * @param height The integer level (in blocks)
     * @return a Block
     */
    public Block getBlock(int column, int level) {

        Column[] columns = BlockManager.getInstance().getColumns();
        if (column >= 0 && column < 10) {
            if (columns[column].getBlocks().size() > level && level >= 0) {
                Block result = columns[column].getBlocks().get(level);
                if(bustList.contains(result)){
                    return null;
                }
                return result;
            }
        }
        return null;
    }
}