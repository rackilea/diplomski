import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class LayeredExample extends JLayeredPane {
   public static final String MAP_URL = "http://upload.wikimedia.org/" +
        "wikipedia/commons/c/c4/Maps-for-free_Sierra_Nevada.png";
   public static final String COMPASS_URL = "http://upload.wikimedia.org/" +
        "wikipedia/commons/thumb/f/f8/Compass_Rose_English_North.svg/" +
        "200px-Compass_Rose_English_North.svg.png";
   private Dimension imageSize;
   private JLabel defaultLabel = new JLabel();
   private JPanel palettePane = new JPanel();
   private JLabel compassLabel = new JLabel();

   public LayeredExample() {
      try {
         URL mapUrl = new URL(MAP_URL);
         BufferedImage mapImage = ImageIO.read(mapUrl);
         ImageIcon mapIcon = new ImageIcon(mapImage);
         defaultLabel.setIcon(mapIcon);

         URL compassUrl = new URL(COMPASS_URL);
         BufferedImage compassImage = ImageIO.read(compassUrl);
         ImageIcon compassIcon = new ImageIcon(compassImage);
         compassLabel.setIcon(compassIcon);

         imageSize = new Dimension(mapImage.getWidth(), mapImage.getHeight());
         setPreferredSize(imageSize);
         defaultLabel.setSize(imageSize);
         defaultLabel.setLocation(0, 0);
         palettePane.setSize(imageSize);
         palettePane.setLocation(0, 0);


         JPanel northPalettePane = new JPanel(new BorderLayout());
         northPalettePane.setOpaque(false);
         northPalettePane.add(compassLabel, BorderLayout.EAST);
         palettePane.setOpaque(false);
         palettePane.setLayout(new BorderLayout());
         palettePane.add(northPalettePane, BorderLayout.NORTH);

         add(defaultLabel, JLayeredPane.DEFAULT_LAYER);
         add(palettePane, JLayeredPane.PALETTE_LAYER);
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("LayeredExample");
      frame.getContentPane().add(new LayeredExample());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}