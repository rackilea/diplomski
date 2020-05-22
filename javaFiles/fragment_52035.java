import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SwapImages extends JPanel {
   public static final String PATH1 = "https://duke.kenai.com/iconSized/duke.gif"; 
   public static final String PATH2 = "https://duke.kenai.com/iconSized/penduke-transparent.gif";
   public static final String[] PATHS = {PATH1, PATH2};
   protected static final int MAX_COUNT = 8;
   private JLabel label = new JLabel();
   private List<Icon> icons = new ArrayList<>();
   private int index = 0;

   public SwapImages() throws IOException {
      for (String path : PATHS) {
         URL url = new URL(path);
         BufferedImage img = ImageIO.read(url);
         ImageIcon icon = new ImageIcon(img);
         icons.add(icon);
      }
      label.setIcon(icons.get(index));
      add(label);
      int timerDelay = 500;
      new Timer(timerDelay, new ActionListener() {
         private int count = 0;

         @Override
         public void actionPerformed(ActionEvent e) {
            if (count >= MAX_COUNT) {
               ((Timer) e.getSource()).stop();
               return;
            }
            index++;
            index %= icons.size();
            Icon icon = icons.get(index);
            label.setIcon(icon);
            count++;
         }
      }).start();
   }

   private static void createAndShowGUI() {
      SwapImages paintEg = null;
      try {
         paintEg = new SwapImages();
      } catch (IOException e) {
         e.printStackTrace();
      }

      JFrame frame = new JFrame("SwapImages");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(paintEg);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}