import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block {

    private Color       color;

    private Rectangle   rectangle;

    public Block(int x, int y, int width, int height) {
        this(new Rectangle(x, y, width, height));
    }

    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.color = Color.BLUE;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(rectangle.x, rectangle.y, 
                rectangle.width, rectangle.height);
    }
}