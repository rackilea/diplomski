import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Resource{
    public static BufferedImage loadImage(String imageFileName){
        URL url = Resource.class.getResource(imageFileName);
        if(url == null) return null;

        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ImageIcon loadIcon(String imageFileName){
        BufferedImage i = loadImage(imageFileName);
        if(i == null) return null;
        return new ImageIcon(i);
    }
}