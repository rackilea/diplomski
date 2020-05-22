import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadImage {
  BufferedImage image;
  void load() throws Exception { 
    image = ImageIO.read(getClass().getResourceAsStream("lena.png"));
  }

  public Dimension getImageSize() {
    return new Dimension(image.getWidth(), image.getHeight());
  }

  public int[] getImagePixels() {
    int [] dummy = null;
    int wid, hgt;

    // compute size of the array
    wid = image.getWidth();
    hgt = image.getHeight();

    // start getting the pixels
    Raster pixelData;
    pixelData = image.getData();

    System.out.println("wid:"+ wid);
    System.out.println("hgt:"+ hgt);
    System.out.println("Channels:"+pixelData.getNumDataElements());
    return pixelData.getPixels(0, 0, wid, hgt, dummy);
  }

  public static void main(String[] args) throws IOException, Exception {
    LoadImage l = new LoadImage();
    l.load();
    int[] pixel;
    pixel= l.getImagePixels();
    System.out.println("length:"+pixel.length);

    int height = 482;
    int width = 372;
    int channels = 3;
    int color = 0;

    BufferedImage red = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
    BufferedImage green = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
    BufferedImage blue = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        blue.setRGB(x, y, pixel[color * channels]);
        green.setRGB(x, y, pixel[color * channels + 1] << 8);
        red.setRGB(x, y, pixel[color * channels + 2] << 16);
        color++;
      }
    }
    ImageIO.write(red, "png", new File("red.png"));
    ImageIO.write(green, "png", new File("green.png"));
    ImageIO.write(blue, "png", new File("blue.png"));
  }
}