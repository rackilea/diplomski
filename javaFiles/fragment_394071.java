import java.awt.Graphics;
import javax.swing.DebugGraphics;

public class GraphicsWorkaround extends DebugGraphics {
    private final Graphics g;

    public GraphicsWorkaround(Graphics g) {
        super(g);
        this.g = g;
    }

    @Override
    public Graphics create() {
        return new GraphicsWorkaround(g.create());
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
        if (width == 1)
            g.drawLine(x, y, x, y + height - 1);
        else if (height == 1)
            g.drawLine(x, y, x + width - 1, y);
        else
            super.fillRect(x, y, width, height);
    }
}