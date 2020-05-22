import org.imgscalr.Scalr.*;
import java.awt.Color;

public static BufferedImage createThumbnail(BufferedImage img) {
    // Target width of 500x500 is used
    img = resize(img, 500); 
    return pad(img, 2, Color.BLACK);
}