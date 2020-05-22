import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class GridBagExample {
   public static void main(String[] args) {
      JPanel mainPanel = new JPanel(new GridBagLayout());

      GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
            GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(
                  0, 0, 0, 0), 0, 0);
      mainPanel.add(new JLabel("Left Upper"), gbc);

      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.anchor = GridBagConstraints.NORTHEAST;
      mainPanel.add(new JLabel("Right Upper"), gbc);

      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.anchor = GridBagConstraints.SOUTHWEST;
      mainPanel.add(new JLabel("Left Lower"), gbc);

      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.anchor = GridBagConstraints.SOUTHEAST;
      mainPanel.add(new JLabel("Right Lower"), gbc);

      JFrame frame = new JFrame("Test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.setLocationRelativeTo(null);
      frame.pack();
      frame.setVisible(true);
   }
}