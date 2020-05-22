import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.JPanel;

public class ImagePanel
extends JPanel {
    private static final long serialVersionUID = 1;

    private Image image;

    public ImagePanel(Image image) {
        this.image = image;
    }

    @Override
    public Dimension getPreferredSize() {
        Insets insets = getInsets();
        Dimension size = new Dimension(
            insets.left + insets.right, insets.top + insets.bottom);

        if (image != null) {
            int width = image.getWidth(this);
            int height = image.getHeight(this);

            size.width += Math.max(width, 0);
            size.height += Math.max(height, 0);
        }

        return size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
            int width = image.getWidth(this);
            int height = image.getHeight(this);
            if (width > 0 && height > 0) {
                int widthDifference = getWidth() - width;

                int x = widthDifference / 2;
                if (widthDifference % 2 != 0) {
                    // If you want the extra space on the left:
                    //x++;
                }

                int y = (getHeight() - height) / 2;

                g.drawImage(image, x, y, this);
            }
        }
    }
}