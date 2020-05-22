import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Main {

    public static final String RES_PATH = "/my/resources";//as you can see we add / to the begining of the name and replace all periods with /
    public static final String FILENAME = "Test.jpg";//the case sensitive file name

    /*
     * This is our method which will use getResource to extarct a BufferedImage
     */
    public BufferedImage extractImageWithResource(String name) throws Exception {

        BufferedImage img = ImageIO.read(this.getClass().getResource(name));

        if (img == null) {
            throw new Exception("Input==null");
        } else {
            return img;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedImage img = new Main().extractImageWithResource(RES_PATH + "/" + FILENAME);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}