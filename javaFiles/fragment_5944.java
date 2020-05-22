package p1;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a singleton to control the blocks and is visible
 * from the other classes in the application.
 * @author Ted
 */
public class BlockManager {

    /**
     * The single instance of a falling block.
     */
    private Block fallingBlock;

    /**
     * All blocks on the page, including the falling one.
     */
    private List<Block> allBlocks;

    /**
     * The array of columns at the bottom, containing blocks.
     */
    private Column[] columns;

    /**
     * Creates an instance of a BlockManager class.  As part
     * of the singleton pattern, this is private so that
     * you can only access the shared instance.
     */
    private BlockManager() {
        allBlocks = new ArrayList<Block>();
        columns = new Column[9];
        for(int i = 0; i < 9; i++)
        {
            columns[i] = new Column();
        }
    }

    /**
     * Gets the single shared instance of the singleton.
     * @return BlockManager
     */
    public static BlockManager getInstance() {
        return BlockManagerHolder.INSTANCE;
    }
    private static class BlockManagerHolder {
        private static final BlockManager INSTANCE = new BlockManager();
    }

    /**
     * Adds a new falling block to the top of the control.
     */
    public void AddBlock(){
        fallingBlock = new Block(0, 3, 20);
        allBlocks.add(fallingBlock);
    }

    /**
     * Removes the specified block.
     * @param block 
     */
    public void RemoveBlock(Block block){
        allBlocks.remove(block);
        List<Block> blocks = columns[block.getColumn()].getBlocks();
        if(blocks.size() > block.getLevel()){
           for(int i = block.getLevel(); i < blocks.size(); i++)
           {
               // Make blocks above this block drop.
               blocks.get(i).getBounds().y += 20;

           }
        }
        columns[block.getColumn()].getBlocks().remove(block);
    }



    /**
     * Gets the falling block.
     * @return the fallingBlock
     */
    public Block getFallingBlock() {
        return fallingBlock;
    }

    /**
     * Sets the falling block.
     * @param fallingBlock the fallingBlock to set
     */
    public void setFallingBlock(Block fallingBlock) {
        this.fallingBlock = fallingBlock;
    }

    /**
     * Gets the list of all blocks visible on the form,
     * including the falling block.
     * @return the allBlocks
     */
    public List<Block> getAllBlocks() {
        return allBlocks;
    }

    /**
     * Sets the list of all blocks visible on the form,
     * including the falling block.
     * @param allBlocks the allBlocks to set
     */
    public void setAllBlocks(List<Block> allBlocks) {
        this.allBlocks = allBlocks;
    }

    /**
     * Gets the array of columns containing blocks at the bottom.
     * @return the columns
     */
    public Column[] getColumns() {
        return columns;
    }

    /**
     * Sets the array of columns containing blocks at the bottom.
     * @param columns the columns to set
     */
    public void setColumns(Column[] columns) {
        this.columns = columns;
    }


}