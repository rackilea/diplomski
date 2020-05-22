import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SquaresInArea extends JPanel {

    private static final int CELL_SIZE = 30;

    BufferedImage image;
    BufferedImage imageMask;
    Area imageArea;
    Rectangle2D[][] imageGrid;

    public SquaresInArea() {
        try {
            image = ImageIO.read(getClass().getResource("/resources/floorplan.png"));
            imageMask = ImageIO.read(getClass().getResource("/resources/floorplan-black.png"));
        } catch (IOException ex) {
            Logger.getLogger(SquaresInArea.class.getName()).log(Level.SEVERE, null, ex);
        }
        imageArea = getOutline(Color.BLACK, imageMask);
        imageGrid = createGrid();
    }

    private Rectangle2D[][] createGrid() {
        int width = image.getWidth();
        int height = image.getHeight();
        int rows = height / CELL_SIZE;
        int cols = width / CELL_SIZE;
        Rectangle2D[][] grid = new Rectangle2D[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            int y = i * CELL_SIZE;
            for (int j = 0; j < grid[i].length; j++) {
                int x = j * CELL_SIZE;
                grid[i][j] = new Rectangle2D.Double(x, y, CELL_SIZE, CELL_SIZE);
            }
        }
        return grid;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, this);
        g2.setColor(Color.YELLOW);
        g2.setStroke(new BasicStroke(3f));
        for (Rectangle2D[] rects : imageGrid) {
            for (Rectangle2D rect : rects) {
                if (imageArea.contains(rect)) {
                    g2.drawRect((int) rect.getX(), (int) rect.getY(),
                            (int) rect.getWidth(), (int) rect.getHeight());
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return image == null ? new Dimension(300, 300)
                : new Dimension(image.getWidth(), image.getHeight());

    }

    private Area getOutline(Color target, BufferedImage bi) {
        // construct the GeneralPath
        GeneralPath gp = new GeneralPath();

        boolean cont = false;
        int targetRGB = target.getRGB();
        for (int xx = 0; xx < bi.getWidth(); xx++) {
            for (int yy = 0; yy < bi.getHeight(); yy++) {
                if (bi.getRGB(xx, yy) == targetRGB) {
                    if (cont) {
                        gp.lineTo(xx, yy);
                        gp.lineTo(xx, yy + 1);
                        gp.lineTo(xx + 1, yy + 1);
                        gp.lineTo(xx + 1, yy);
                        gp.lineTo(xx, yy);
                    } else {
                        gp.moveTo(xx, yy);
                    }
                    cont = true;
                } else {
                    cont = false;
                }
            }
            cont = false;
        }
        gp.closePath();

        // construct the Area from the GP & return it
        return new Area(gp);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new SquaresInArea());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}