import java.awt.*;
import javax.imageio.*;
import org.imgscalr.Scalr;

void createThumbnailUsingScalr(File sourceImage) throws Exception {
        File destImage =
                new File("/Path/For/Destination/Thubnail.png");
            BufferedImage img = ImageIO.read(sourceImage);
            BufferedImage thumbImg = Scalr.resize(img, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC, 200, 200, Scalr.OP_ANTIALIAS);
            ImageIO.write(thumbImg, "PNG", destImage);
    }