package p1;

import java.util.ArrayList;
import java.util.List;

/**
 * A Column is an object that contains a list of the blocks stored
 * in a vertical stack at the bottom of the game.  Each block object
 * points to the same object instance in allBlocks.
 * @author Ted
 */
public class Column {
    private static int maxHeight = 340;
    private List<Block> blocks;

    /**
     * Gets the maximum vertical pixel height of the form.
     * @return the maxHeight
     */
    public static int getMaxHeight() {
        return maxHeight;
    }

    /**
     * Sets the maximum vertical pixel height of the form.
     * @param aMaxHeight the maxHeight to set
     */
    public static void setMaxHeight(int aMaxHeight) {
        maxHeight = aMaxHeight;
    }


    /**
     * Creates a new instance of the column class.
     */
    public Column(){
        blocks = new ArrayList<Block>();
    }

    /**
     * Gets the amount of space remaining in this column
     * @return 
     */
    public int getDepthRemaining(){
        return maxHeight - getBlockHeight();
    }

    /**
     * Gets the total height of all the blocks in this column
     * @return 
     */
    public int getBlockHeight(){
        int height = 0;
        for(Block block : blocks){
            height += block.getBounds().height;
        }
        return height;
    }

    /**
     * Gets the list of blocks associated with this column.
     * The 0 index is at the bottom.
     * @return the dropObjects
     */
    public List<Block> getBlocks() {
        return blocks;
    }

    /**
     * Sets the list of blocks associated with this column.
     * @param dropObjects the dropObjects to set
     */
    public void setBlocks(List<Block> dropObjects) {
        this.blocks = dropObjects;
    }
}