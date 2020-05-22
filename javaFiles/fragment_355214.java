import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageTest {


    public static void main(String[] args) throws IOException {

        int width = 10 // width of your image
        int height = 10 // height of your image

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height; ++y)
            {
                int grayscale = ... // get your greyscale value 0..255 from your array here.
                int colorValue = grayscale | grayscale << 8 | grayscale << 16;
                img.setRGB(x, y, colorValue);
            }

        }

        ImageIO.write(img, "png", new File("output.png"));
    }

}