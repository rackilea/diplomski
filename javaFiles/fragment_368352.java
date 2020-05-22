import java.awt.Dialog.ModalityType;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class LogInDialogTest {

   private static void createAndShowGui() {
      final MainJPanel mainPanel = new MainJPanel();

      JFrame frame = new JFrame("Frame");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      // frame.setVisible(true);

      LoginJPanel loginPanel = new LoginJPanel();
      JDialog dialog = new JDialog(frame, "Dialog",
            ModalityType.APPLICATION_MODAL);
      dialog.getContentPane().add(loginPanel);
      dialog.pack();
      dialog.setLocationRelativeTo(frame);
      dialog.setVisible(true);

      mainPanel.textFieldSetText(loginPanel.textFieldGetText());
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

class LoginJPanel extends JPanel {
   private JTextField textField = new JTextField(10);

   public LoginJPanel() {
      add(textField);
      add(new JButton(new AbstractAction("Submit") {

         @Override
         public void actionPerformed(ActionEvent evt) {
            JButton thisBtn = (JButton) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(thisBtn);
            win.dispose();
         }
      }));
   }

   public String textFieldGetText() {
      return textField.getText();
   }
}

class MainJPanel extends JPanel {
   private JTextField textField = new JTextField(10);

   public MainJPanel() {
      textField.setEditable(false);
      textField.setFocusable(false);
      add(textField);
      add(new JButton(new AbstractAction("Exit") {

         @Override
         public void actionPerformed(ActionEvent evt) {
            JButton thisBtn = (JButton) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(thisBtn);
            win.dispose();
         }
      }));
   }

   public void textFieldSetText(String text) {
      textField.setText(text);
   }
}