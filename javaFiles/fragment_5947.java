package p1;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class handles the movement of blocks.  This 
 * class was modified to include collision detection
 * with blocks in a neighboring column.
 */
public class InputKey extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        int keys = e.getKeyCode();
        Block block = EventRect.getFallingBlock();
        if (block == null) {
            return;
        }
        Rectangle rect = block.getBounds();
        if (keys == KeyEvent.VK_RIGHT) {
            //Check for right bounds
            if (rect.x < 160) {
                // Check to see if we run into another block
                int level = block.getLevel();
                int column = block.getColumn();
                if (BlockManager.getInstance().getColumns()[column + 1].getBlocks().size() > level) {
                    // we ran into a block
                    return;
                }
                rect.x += 20;
                block.setColumn(rect.x / 20);
            }
        } else if (keys == KeyEvent.VK_LEFT) {
            // Check for left bounds
            if (rect.x > 0) {
                // Check to see if we run into another block
                int level = block.getLevel();
                int column = block.getColumn();
                if (BlockManager.getInstance().getColumns()[column + 1].getBlocks().size() > level) {
                    // we ran into a block
                    return;
                }
                rect.x -= 20;
                block.setColumn(rect.x / 20);
            }
        }
    }
}