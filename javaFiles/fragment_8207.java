package kulatamicuda.aesimage.core;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * Sample class for Stacko.
 * 
 * @author kulatamicuda
 *
 */
public final class Img {

  /**
   * RGB SIZE IS 3 (RED, GREEN, BLUE).
   */
  private static final int RGB_SIZE = 3;

  /**
   * Byte shifter for SIGNED->UNSIGNED.
   */
  private static final int BSHIFT = 0xFF;

  /**
   * Solution sample in main.
   * 
   * @param args
   *          ignored args
   */
  public static void main(String[] args) {
    try {
      BufferedImage image;
      int width;
      int height;

      File input = new File("sample.jpg");
      image = ImageIO.read(input);
      width = image.getWidth();
      height = image.getHeight();

      byte[] t = new byte[width * height * RGB_SIZE];
      int index = 0;

      // fill the table t with RGB values;
      for (int i = 0; i < height; i++) {

        for (int j = 0; j < width; j++) {

          Color c = new Color(image.getRGB(j, i));

          // As byte is SIGNED in Java overflow will occur for values > 127
          byte r = (byte) c.getRed();
          byte g = (byte) c.getGreen();
          byte b = (byte) c.getBlue();

          t[index++] = r;
          t[index++] = g;
          t[index++] = b;
        }
      }

      // Re-create image with table-encrypted RGB values
      BufferedImage newImage = new BufferedImage(width, height,
          BufferedImage.TYPE_3BYTE_BGR);
      index = 0;
      for (int i = 0; i < height; i++) {

        for (int j = 0; j < width; j++) {

          // Need to deal with values < 0 so binary AND with 0xFF
          // Java 8 provides Byte.toUnsignedInt but I am from the old school ;-)
          int r = t[index++] & BSHIFT;
          int g = t[index++] & BSHIFT;
          int b = t[index++] & BSHIFT;

          Color newColor = new Color(r, g, b);
          newImage.setRGB(j, i, newColor.getRGB());

        }
      }
      // write the output image
      File output = new File("output.jpg");
      ImageIO.write(newImage, "jpg", output);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}