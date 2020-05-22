package p1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.TimerTask;
import javax.swing.Timer;
import javax.swing.JPanel;

/**
 * EventRect is the main form for the game.
 */
public class EventRect extends JPanel {
    /**
     * @return the fallingBlock
     */
    public static Block getFallingBlock() {
        return BlockManager.getInstance().getFallingBlock();
    }

    private BlockBuster blockBuster;
    private LinkedList<TimerTask> tasklist = new LinkedList<TimerTask>();
    Timer timet;
    int i = 1;

    /**
     * Creates a new instance of the main form for the project.
     */
    public EventRect() {
        BlockManager.getInstance().AddBlock();
        this.blockBuster = new BlockBuster();
        addKeyListener(new InputKey());
        setFocusable(true);
        startSampling();
    }

    /**
     * Paints all the blocks onto the screen, including the falling block.
     * @param g The Graphics surface of the form.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Block dropObject : BlockManager.getInstance().getAllBlocks()) {
            Rectangle bounds = dropObject.getBounds();
            g2d.setColor(dropObject.getColor());
            g2d.fillRect(bounds.x, bounds.y, bounds.width + 1, bounds.height + 1);
        }
    }

    /**
     * This handles the downward motion of the falling block.
     */
    public void moveRectangle() {
        Column[] columns = BlockManager.getInstance().getColumns();
        if(getFallingBlock().getBounds().getY() >= 
          columns[getFallingBlock().getColumn()].getDepthRemaining()){
            // We hit the top of the column, so add this block to the column
            columns[getFallingBlock().getColumn()].getBlocks().add(getFallingBlock());
            blockBuster.bustBlocks();
            BlockManager.getInstance().AddBlock();
        }
        else{
            BlockManager.getInstance().getFallingBlock().getBounds().y += 20;
        }
    }

    /**
     * This method was made final because it is called from the
     * constructor.  This starts game timers (from original post).
     */
    final void startSampling() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                moveRectangle();
                repaint();
            }
        };
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(task, 0, 150);
        tasklist.add(task);
    }

    /**
     * This method removes the timer from the tasklist.
     */
    void stopSampling() {
        if (tasklist.isEmpty()) {
            return;
        }
        tasklist.removeFirst().cancel();
    }


}