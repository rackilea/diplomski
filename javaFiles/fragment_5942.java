package p1;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class Block {

    /**
     * Color
     */
    private Color color;
    /**
     * The pixel coordinate bounding rectangle for the block.
     */
    private Rectangle bounds;
    /**
     * the integer column
     */
    private int column;

    /**
     * Creates a new instance of a block at the specified
     * 
     * @param y Distance in pixels from the top of the form.
     * @param column The integer column index (0-8)
     * @param size The integer size.
     */
    public Block(int y, int column, int size) {
        this.color = RandomColor();
        this.bounds = new Rectangle(20*column, y, size, size);
        this.column = column;
    }

    /**
     * Gets the color of this block.
     * @return the color of this block.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Gets the pixel bounds for this block.
     * @return The bounds.
     */
    public Rectangle getBounds() {
        return bounds;
    }

    /**
     * Sets the bounds for this block.
     * @param object 
     */
    public void setBounds(Rectangle object) {
        this.bounds = object;
    }

    /**
     * This is Elevation in units of blocks, like column 
     * @return 
     */
    public int getLevel(){
        return (340 - this.getBounds().y)/20;
    }

    /**
     * Gets the bottom of the block.
     * @return 
     */
    public int getBottom(){
        return this.bounds.y + this.bounds.height;
    }

    /**
     * Gets the integer column index of the block (0-8)
     * @return the column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Sets the integer column index of the block (0-8)
     * @param column the column to set
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Generates a random color.
     * @return Color
     */
    public static Color RandomColor() {
        Color[] Array = {Color.blue, Color.pink, Color.gray};
        Random random = new Random();
        return Array[random.nextInt(Array.length)];
    }
}