import java.awt.Graphics;

import javax.swing.JPanel;

public class CustomPaintingComponent extends JPanel
{
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);    // This will clear everything...

        // ... now you can apply your custom painting, for example:
        g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);  // A line from upper left to lower right corner
    }
}