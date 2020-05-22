import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MCVE extends JFrame {
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static void main(String[] args) {
        MCVE mcve = new MCVE();
        mcve.setVisible(true);
        mcve.setSize(WIDTH, HEIGHT);
        mcve.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        render((Graphics2D) g);
    }

    public BufferedImage[][] tile;
    public static final int TILE_SIZE = 16;
    private static BufferedImage spritesheet = BufferedImageLoader
            .load("tiles.png");
    private static final BufferedImage bricks = crop(0, 0);
    private static final BufferedImage dirt = crop(1, 0);
    private static final BufferedImage grass = crop(2, 0);
    private static final BufferedImage levelImage = BufferedImageLoader.load("level1.png");
    int widthInTiles;
    int heightInTiles;

    private static BufferedImage crop(int x, int y) {
        return spritesheet.getSubimage(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE,
                TILE_SIZE);
    }

    public MCVE() {
        widthInTiles = levelImage.getWidth();
        heightInTiles = levelImage.getHeight();

        generateLevel();
    }

    public void generateLevel() {
        tile = new BufferedImage[widthInTiles][heightInTiles];
        for (int y = 0; y < heightInTiles; y++) {
            for (int x = 0; x < widthInTiles; x++) {
                Color c = new Color(levelImage.getRGB(x, y));
                switch (c.getRGB()) {
                case -8158333:
                    tile[x][y] = bricks;
                    break;
                case -14429696:
                    tile[x][y] = grass;
                    break;
                case -4284160:
                    tile[x][y] = dirt;
                }
            }
        }
    }

    public void render(Graphics2D screen) {
        int scale = 16;
        int yes = 0, no = 0;
        for (int y = 0; y < heightInTiles; y++) {
            for (int x = 0; x < widthInTiles; x++) {
                if (tile[x][y] != null) {
                    screen.drawImage(tile[x][y], (int) (x * (TILE_SIZE + scale)),
                            (int) (y * (TILE_SIZE + scale)),
                            (TILE_SIZE + scale), (TILE_SIZE + scale),
                            Color.BLACK, null);
                }
            }
        }
    }

    public static class BufferedImageLoader {
        public static BufferedImage load(String path) {
            try {
                return ImageIO.read(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new NullPointerException("No file found at: " + path);
        }

        public static BufferedImage load(URL url) {
            try {
                return ImageIO.read(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new NullPointerException("No file found at: " + url.getPath());
        }
    }
}