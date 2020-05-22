import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.Border;

public class Foo1 {
   private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
   private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);
   private JPanel dialogPanel;
   private JTextField creditCardNoInput;
   private JTextField sortCodeInput;
   private JTextField secNoInput;
   private JTextField cardHolderName;

   public Foo1() {
      dialogPanel = new JPanel(new GridBagLayout());

      Border titleBorder = BorderFactory.createTitledBorder("Credit Card Information");
      Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
      Border combinedBorder = BorderFactory.createCompoundBorder(titleBorder, emptyBorder);
      dialogPanel.setBorder(combinedBorder);
      creditCardNoInput = new JTextField(5);
      sortCodeInput = new JTextField(5);
      secNoInput = new JTextField(5);
      cardHolderName = new JTextField(5);

      dialogPanel.add(new JLabel("Credit Card Number:"), createGbc(0, 0));
      dialogPanel.add(creditCardNoInput, createGbc(1, 0));
      dialogPanel.add(new JLabel("Sort Code:"), createGbc(0, 1));
      dialogPanel.add(sortCodeInput, createGbc(1, 1));
      dialogPanel.add(new JLabel("Second Number:"), createGbc(0, 2));
      dialogPanel.add(secNoInput, createGbc(1, 2));
      dialogPanel.add(new JLabel("Cardholder Name:"), createGbc(0, 3));
      dialogPanel.add(cardHolderName, createGbc(1, 3));

      int result = JOptionPane.showConfirmDialog(null, dialogPanel,
            "Please Enter your card details", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);

      if (result == JOptionPane.OK_OPTION) {
         // Execute desired code
      }
   }

   private static GridBagConstraints createGbc(int x, int y) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;

      gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
      gbc.fill = (x == 0) ? GridBagConstraints.BOTH
            : GridBagConstraints.HORIZONTAL;

      gbc.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;
      gbc.weightx = (x == 0) ? 0.1 : 1.0;
      gbc.weighty = 1.0;
      return gbc;
   }

   private static void createAndShowGui() {
      new Foo1();
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}