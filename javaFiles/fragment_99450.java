import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class AnonInnerPanel {

   private static void createAndShowGui() {
      JPanel mainPanel = new JPanel() {
         @Override
         protected void paintComponent(Graphics g) {
            super.paintComponent(g);
         }

         @Override
         public Dimension getPreferredSize() {
            return new Dimension(300, 200);
         }
      };

      JFrame frame = new JFrame("AnonInnerPanel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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