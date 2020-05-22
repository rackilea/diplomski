import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainFoo extends JPanel {
   private static final int COLUMNS = 10;
   private JTextField userNameField = new JTextField(COLUMNS);
   private JTextField passwordField = new JTextField(COLUMNS);
   private InputForm inputForm = new InputForm();

   public MainFoo() {
      add(new JLabel("User Name:"));
      add(userNameField);
      add(Box.createHorizontalStrut(15));
      add(new JLabel("Password:"));
      add(passwordField);
      add(new JButton(new LogInAction("Log in", KeyEvent.VK_L)));
   }

   private class LogInAction extends AbstractAction {
      public LogInAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         int result = JOptionPane.showConfirmDialog(null, inputForm, "Input Form",
               JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
         if (result == JOptionPane.OK_OPTION) {
            userNameField.setText(inputForm.getUserName());


            // ***** never do this! ***** 
            // Never change a password into a String.
            // This is for demo purposes only.
            passwordField.setText(new String(inputForm.getPassword())); 
         }
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("MainFoo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new MainFoo());
      frame.pack();
      frame.setLocationRelativeTo(null);
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


@SuppressWarnings("serial")
class InputForm extends JPanel {
   private static final int COLUMNS = 10;
   private static final int GAP = 3;
   private static final Insets LABEL_INSETS = new Insets(GAP, GAP, GAP, 15);
   private static final Insets TEXTFIELD_INSETS = new Insets(GAP, GAP, GAP, GAP);
   private JTextField userNameField = new JTextField(COLUMNS);
   private JPasswordField passwordField = new JPasswordField(COLUMNS);

   public InputForm() {
      setLayout(new GridBagLayout());
      addLabel("User Name:", 0);
      addTextField(userNameField, 0);

      addLabel("Password:", 1);
      addTextField(passwordField, 1);

   }

   public String getUserName() {
      return userNameField.getText();
   }

   public char[] getPassword() {
      return passwordField.getPassword();
   }


   private void addTextField(JTextField field, int row) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.gridx = 1;
      gbc.gridy = row;
      gbc.anchor = GridBagConstraints.EAST;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = TEXTFIELD_INSETS;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      add(field, gbc);
   }

   private void addLabel(String text, int row) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.gridx = 0;
      gbc.gridy = row;
      gbc.anchor = GridBagConstraints.WEST;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.insets = LABEL_INSETS;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      add(new JLabel(text), gbc);
   }
}