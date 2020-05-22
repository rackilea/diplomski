import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RotateImage {
   public static final String IMAGE_PATH = "http://duke.kenai.com/"
         + "models/Duke3DprogressionSmall.jpg";

   public static void main(String[] args) {
      try {
         URL imageUrl = new URL(IMAGE_PATH);
         BufferedImage img0 = ImageIO.read(imageUrl);
         ImageIcon icon0 = new ImageIcon(img0);

         int numquadrants = 1;
         BufferedImage img1 = transform(img0, numquadrants );
         ImageIcon icon1 = new ImageIcon(img1);

         JOptionPane.showMessageDialog(null, new JLabel(icon0));
         JOptionPane.showMessageDialog(null, new JLabel(icon1));

      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static BufferedImage transform(BufferedImage image, int numquadrants) {
      int w0 = image.getWidth();
      int h0 = image.getHeight();
      int w1 = w0;
      int h1 = h0;

      int centerX = w0 / 2;
      int centerY = h0 / 2;

      if (numquadrants % 2 == 1) {
         w1 = h0;
         h1 = w0;
      }

      if (numquadrants % 4 == 1) {
         if (w0 > h0) {
            centerX = h0 / 2;
            centerY = h0 / 2;
         } else if (h0 > w0) {
            centerX = w0 / 2;
            centerY = w0 / 2;
         }
         // if h0 == w0, then use default
      } else if (numquadrants % 4 == 3) {
         if (w0 > h0) {
            centerX = w0 / 2;
            centerY = w0 / 2;
         } else if (h0 > w0) {
            centerX = h0 / 2;
            centerY = h0 / 2;
         }
         // if h0 == w0, then use default
      }

      AffineTransform affineTransform = new AffineTransform();
      affineTransform.setToQuadrantRotation(numquadrants, centerX, centerY);

      AffineTransformOp opRotated = new AffineTransformOp(affineTransform,
            AffineTransformOp.TYPE_BILINEAR);

      BufferedImage transformedImage = new BufferedImage(w1, h1,
            image.getType());

      transformedImage = opRotated.filter(image, transformedImage);
      return transformedImage;
   }
}