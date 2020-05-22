import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class ColorSquares extends JPanel {
    public static final int SQR_SIDE = 50;
    public static final int COLUMNS = 20;
    public static final int ROWS = 16;
    private int columns;
    private int rows;
    private int sqrSide;
    private Image backgroundImg;    

    public ColorSquares(int columns, int rows, int sqrSide) {
        this.columns = columns;
        this.rows = rows;
        this.sqrSide = sqrSide;
        backgroundImg = createBackground();
        add(new JButton(new AbstractAction("New Background") {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                backgroundImg = createBackground();
                repaint();
            }
        }));
    }

    public Image createBackground() {
        int w = columns * sqrSide;
        int h = rows * sqrSide;
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                float hue = (float) Math.random();
                float saturation = (float) (Math.random() * 0.5 + 0.5);
                float brightness = (float) (Math.random() * 0.5 + 0.5);
                Color randColor = Color.getHSBColor(hue, saturation, brightness);
                g.setColor(randColor);
                int x = c * sqrSide;
                int y = r * sqrSide;
                g.fillRect(x, y, sqrSide, sqrSide);
            }
        }
        g.dispose();
        return img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImg != null) {
            g.drawImage(backgroundImg, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(columns * sqrSide, rows * sqrSide);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Colors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ColorSquares(COLUMNS, ROWS, SQR_SIDE));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}