import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
// extend JPanel, not JFrame as it gives the class more flexibility as to where to use
public class ShowRandomImages extends JPanel {
   // images from Andrew Thompson's example image page,
   // http://stackoverflow.com/questions/19209650/example-images-for-code-and-mark-up-qas
   private static final String IMAGE_SHEET_PATH = "http://i.stack.imgur.com/memI0.png";
   // how many JLabels to show in a row
   private static final int LABEL_COUNT = 3;
   // need to get subimages from image sheet. There are 6 columns in the sheet
   private static final int IMAGE_COLUMNS = 6;
   // array of JLabel
   private JLabel[] labels = new JLabel[LABEL_COUNT];
   // hold all the images as ImageIcons read in
   private List<Icon> imageIconList = new ArrayList<>();
   // to randomize the images
   private Random random = new Random();

   // pass the ImageIcon List into this class
   public ShowRandomImages(List<Icon> iconList) {
      this.imageIconList = iconList;
      // jpanel hold row of image-displaying JLabels
      JPanel labelHolderPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      for (int i = 0; i < labels.length; i++) { // create all JLabels in array
         labels[i] = new JLabel();
         labels[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
         labels[i].setHorizontalAlignment(SwingConstants.CENTER); // center the icon
         labels[i].setIcon(getRandomIcon()); // initialize with a random image
         labelHolderPanel.add(labels[i]); // add to holder JPanel
      }

      // panel to hold button at bottom
      JPanel bottomPanel = new JPanel();
      // button uses an AbstractAction rather than an ActionListener
      bottomPanel.add(new JButton(new ShowRandomIconAction("Show Random Image")));

      setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      setLayout(new BorderLayout());
      add(labelHolderPanel, BorderLayout.CENTER);
      add(bottomPanel, BorderLayout.PAGE_END);
   }

   private Icon getRandomIcon() {
      int randomIndex = random.nextInt(imageIconList.size());
      return imageIconList.get(randomIndex);
   }

   private class ShowRandomIconAction extends AbstractAction {
      public ShowRandomIconAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         for (JLabel jLabel : labels) {
            jLabel.setIcon(getRandomIcon());
         }
      }
   }

   private static void createAndShowGui(List<Icon> imageIconList) {
      ShowRandomImages mainPanel = new ShowRandomImages(imageIconList);

      JFrame frame = new JFrame("ShowRandomImages");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      try {
         final List<Icon> iconList = getImages();
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               createAndShowGui(iconList);
            }
         });
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }
   }

   // read in image sheet and extract sub-images from it
   private static List<Icon> getImages() throws IOException {
      List<Icon> iconList = new ArrayList<>();
      URL imageUrl = new URL(IMAGE_SHEET_PATH);
      BufferedImage imageSheet = ImageIO.read(imageUrl);
      for (int i = 0; i < IMAGE_COLUMNS; i++) {
         int x = (int) ((double) i * imageSheet.getWidth() / IMAGE_COLUMNS);
         int y = 0;
         int w = imageSheet.getWidth() / IMAGE_COLUMNS;
         int h = imageSheet.getHeight() / 2;

         BufferedImage subImage = imageSheet.getSubimage(x, y, w, h);
         iconList.add(new ImageIcon(subImage));
      }
      return iconList;
   }
}