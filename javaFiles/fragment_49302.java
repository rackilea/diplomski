import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImageGrid extends JPanel {

    private static final int CELLS = 10;

    BufferedImage img;

    public ImageGrid() {
        try {
            img = ImageIO.read(getClass().getResource("/resources/stackoverflow5.png"));
        } catch (IOException ex) {
            Logger.getLogger(ImageGrid.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
            int cellHeight = (int) (getHeight() / CELLS); 
            int cellWidth = (int) (getWidth() / CELLS);
            for (int y = 0; y < getHeight(); y += cellHeight) {
                for (int x = 0; x < getWidth(); x += cellWidth) {
                    g.drawRect(x, y, cellWidth, cellHeight);

                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return img == null ? new Dimension(300, 300) 
                : new Dimension(img.getWidth(), img.getHeight());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                JPanel wrapperPanel = new JPanel(new GridBagLayout());
                wrapperPanel.add(new ImageGrid());
                frame.add(wrapperPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}