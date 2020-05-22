import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JPanel {
    private static final int CELL_WIDTH = 20;
    private static final Color CORRIDOR_COLOR = Color.LIGHT_GRAY;
    private static final Color WALL_COLOR = Color.DARK_GRAY;
    private static final Color END_COLOR = Color.ORANGE;
    private static final Color SPRITE_COLOR = Color.RED;
    private static final int GAP = 1;
    private BufferedImage gridImg = null;
    private SpritePosition spritePosition;
    private JPanel mainPanel = new JPanel();

    public View(MatrixModel matrixModel) {
        gridImg = createImg(matrixModel);
        spritePosition = matrixModel.getSpritePosition();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || gridImg == null) {
            return super.getPreferredSize();
        }
        int prefW = gridImg.getWidth();
        int prefH = gridImg.getHeight();
        return new Dimension(prefW, prefH);
    }

    public void setSpritePoint(SpritePosition spritePosition) {
        this.spritePosition = spritePosition;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gridImg != null) {
            g.drawImage(gridImg, 0, 0, this);
        }
        g.setColor(SPRITE_COLOR);
        int y = spritePosition.row * CELL_WIDTH + GAP;
        int x = spritePosition.column * CELL_WIDTH + GAP;
        g.fillRect(x, y, CELL_WIDTH - 2 * GAP, CELL_WIDTH - 2 * GAP);
    }

    private BufferedImage createImg(MatrixModel matrixModel) {
        BufferedImage img = null;
        if (matrixModel != null && matrixModel.getRows() > 0) {
            int w = matrixModel.getColumns() * CELL_WIDTH;
            int h = matrixModel.getRows() * CELL_WIDTH;
            img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            for (int row = 0; row < matrixModel.getRows(); row++) {
                for (int col = 0; col < matrixModel.getColumns(); col++) {
                    MatrixPosition position = matrixModel.getPosition(row, col);
                    Color c = null;
                    switch (position) {
                    case CORRIDOR:
                        c = CORRIDOR_COLOR;
                        break;
                    case WALL:
                        c = WALL_COLOR;
                        break;
                    case END:
                        c = END_COLOR;
                        break;
                    }
                    g2.setColor(c);
                    int x = col * CELL_WIDTH;
                    int y = row * CELL_WIDTH;
                    g2.fillRect(x, y, CELL_WIDTH, CELL_WIDTH);
                }
            }
            g2.dispose();
        }
        return img;
    }

}