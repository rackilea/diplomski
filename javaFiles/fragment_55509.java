import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MCVCon extends JFrame {
    //setting up variables

    public MCVCon() {
        //creating the window
        super("Conqueror");
        add(new GamePane());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MCVCon frame = new MCVCon();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    //necessary overrides

    public class GamePane extends JPanel {

        public BufferedImage[] img = new BufferedImage[9];
        private final int width = 5, height = 5;
        private int scale = 16;
        int t[][] = new int[width][height]; //terrain type (since I took out the terrain generation it is set to 0 or ocean)
        Color[] colors = new Color[]{
            Color.RED,
            Color.BLUE,
            Color.CYAN,
            Color.DARK_GRAY,
            Color.GRAY,
            Color.GREEN,
            Color.LIGHT_GRAY,
            Color.MAGENTA,
            Color.ORANGE,
            Color.PINK,
            Color.YELLOW
        };
        int tileHeight = 10;
        int tileWidth = 10;

        public GamePane() {
            loadImages();

            Random rnd = new Random();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int value = rnd.nextInt(9);
                    System.out.println(value + "- " + colors[value]);
                    t[x][y] = value;
                }
            }

            Timer timer = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width * tileWidth * scale, height * tileHeight * scale);
        }

        public void loadImages() {
            for (int i = 0; i < 9; i++) {
                try {
                    img[i] = new BufferedImage(tileWidth, tileHeight, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2d = img[i].createGraphics();
                    g2d.setColor(colors[i]);
                    g2d.fill(new Rectangle(0, 0, tileWidth, tileHeight));
                    g2d.dispose();
                } catch (Exception ex) {
                    System.out.println("Missing Image");
                    ex.printStackTrace();
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setTransform(AffineTransform.getScaleInstance(scale, scale));
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    g2d.drawImage(img[t[x][y]], x * tileWidth, y * tileHeight, this);
                }
            }
            g2d.dispose();
        }

    }
}