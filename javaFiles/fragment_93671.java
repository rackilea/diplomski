import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class LayoutEg {

   private static void createAndShowGui() {
      String[] labelStrings = {"One", "Two", "Three", "Four"};
      JPanel topPanel = new JPanel(new GridLayout(1, 0));
      for (String labelString : labelStrings) {
         // create labels and center the text
         topPanel.add(new JLabel(labelString, SwingConstants.CENTER)); 
      }
      topPanel.setBackground(Color.red);

      JPanel centerPanel = new JPanel();
      centerPanel.setBackground(Color.blue);

      // setting preferred size for demonstration purposes only
      centerPanel.setPreferredSize(new Dimension(700, 400));

      JPanel bottomPanel = new JPanel();
      bottomPanel.setBackground(Color.green);

      // main panel uses BorderLayout
      JPanel mainPanel = new JPanel(new BorderLayout());
      mainPanel.add(centerPanel, BorderLayout.CENTER);
      mainPanel.add(topPanel, BorderLayout.PAGE_START);
      mainPanel.add(bottomPanel, BorderLayout.PAGE_END);


      JFrame frame = new JFrame("LayoutEg");
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