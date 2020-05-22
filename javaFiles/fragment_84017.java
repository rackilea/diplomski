import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class Test {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // assuming that picture is your byte array
        byte[] picture = new byte[30];

        InputStream in = new ByteArrayInputStream(picture);

        BufferedImage buf = ImageIO.read(in);
        ColorModel model = buf.getColorModel();
        int height = buf.getHeight();

    }

}