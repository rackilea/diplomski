import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.*;

public class SimpleLayout {
   private static final Color GREEN = new Color(200, 255, 200);
   private static final Color BLUE = new Color(200, 200, 255);

   private static void createAndShowGui() {
      JFrame frame = new JFrame("SimpleLayout");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // note that a JFrame's contentPane uses BorderLayout by default
      frame.getContentPane().add(new ColorPanel(Color.pink, 800, 80), BorderLayout.NORTH);
      frame.getContentPane().add(new ColorPanel(GREEN, 300, 420), BorderLayout.WEST);
      frame.getContentPane().add(new ColorPanel(BLUE, 500, 420), BorderLayout.CENTER);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class ColorPanel extends JPanel {
   private static final float FONT_POINTS = 24f;
   private int prefW;
   private int prefH;

   public ColorPanel(Color color, int prefW, int prefH) {
      setBackground(color);
      this.prefW = prefW;
      this.prefH = prefH;

      // GBL can be useful for simply centering components
      setLayout(new GridBagLayout()); 
      String text = String.format("%d x %d", prefW, prefH);
      JLabel label = new JLabel(text, SwingConstants.CENTER);
      label.setFont(label.getFont().deriveFont(FONT_POINTS));
      label.setForeground(Color.gray);
      add(label);
   }



   @Override
   public Dimension getPreferredSize() {
      return new Dimension(prefW, prefH);
   }
}