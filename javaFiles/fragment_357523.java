import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawShapeOnImage {

    private static BufferedImage br;

    public static void main(String[] args) throws IOException {
        try {
            br = ImageIO.read(new File("resources/1.png"));
            ImageIO.write(getTexturedImage(), "png", new File("resources/2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getTexturedImage() {
        BufferedImage tmp = new BufferedImage(br.getWidth(), br.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = tmp.createGraphics();
        g.drawImage(br, 0, 0, null);
        g.setColor(Color.BLACK);
        g.drawRect(20, 20, 10, 10);
        g.dispose();

        return tmp;
    }

}