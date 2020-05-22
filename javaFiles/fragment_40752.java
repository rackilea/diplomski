import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class BorderLayoutExample {
   public static void main(String[] args) {
      JPanel northPanel = new JPanel(new BorderLayout());      
      northPanel.add(new JLabel("North East"), BorderLayout.EAST);
      northPanel.add(new JLabel("North West"), BorderLayout.WEST);

      JPanel southPanel = new JPanel(new BorderLayout());
      southPanel.add(new JLabel("South East"), BorderLayout.EAST);
      southPanel.add(new JLabel("South West"), BorderLayout.WEST);


      JPanel mainPanel = new JPanel(new BorderLayout());
      mainPanel.add(northPanel, BorderLayout.NORTH);
      mainPanel.add(southPanel, BorderLayout.SOUTH);

      JFrame frame = new JFrame("BorderLayout Test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }
}