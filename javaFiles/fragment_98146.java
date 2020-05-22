import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class Resources {
    private final static String NL = System.getProperty("line.separator");

    public static final int TILE_WIDTH = 23;// 578;
    public static final int TILE_HEIGHT = 29;// 720;

    public static BufferedImage BACKGROUND = new BufferedImage(TILE_WIDTH, TILE_HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    public static BufferedImage PACMAN = new BufferedImage(TILE_WIDTH, TILE_HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    public static BufferedImage SETTINGS_BACKGROUND = new BufferedImage(TILE_WIDTH, TILE_HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    public static BufferedImage LEVEL1 = new BufferedImage(TILE_WIDTH, TILE_HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    /*public static BufferedImage LEVEL2 = new BufferedImage(TILE_WIDTH, TILE_HEIGHT,
            BufferedImage.TYPE_INT_RGB);*/
    public static BufferedImage POINTS = new BufferedImage(TILE_WIDTH, TILE_HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    public static BufferedImage POINT = new BufferedImage(TILE_WIDTH, TILE_HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    public static BufferedImage WALL = new BufferedImage(TILE_WIDTH, TILE_HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    public static BufferedImage BLACK_BACK = new BufferedImage(TILE_WIDTH, TILE_HEIGHT,
            BufferedImage.TYPE_INT_RGB);
    public static BufferedImage POINT_BACK = new BufferedImage(TILE_WIDTH, TILE_HEIGHT,
            BufferedImage.TYPE_INT_RGB);

    public static void loadResources() {
        try {
            BACKGROUND = ImageIO.read(new File("res\\Background.png"));
            WALL = ImageIO.read(new File("res\\maptile.png"));
            PACMAN = ImageIO.read(new File("res\\pacman.png"));
            SETTINGS_BACKGROUND = ImageIO.read(new File("res\\Background.png"));
            LEVEL1 = ImageIO.read(new File("res\\level1.png"));
            POINT = ImageIO.read(new File("res\\Points for pacman.png"));
            BLACK_BACK = ImageIO.read(new File("res\\blackBack.png"));
            POINT_BACK = ImageIO.read(new File("res\\points.png"));

        } catch (IOException e) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ WARNING! ~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("There was am Image unsuccessfully loaded!"
                            + NL
                            + "The game may not work properly, check the load images method for spelling errors!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ WARNING! ~~~~~~~~~~~~~~~~~~~~~~~~~~"
                            + NL + NL);

        }
    }
}