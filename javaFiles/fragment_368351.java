import java.awt.Dialog.ModalityType;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class LogInDialogTest {

   private static void createAndShowGui() {
      JTextField textField1 = new JTextField(10);
      textField1.setEditable(false);
      textField1.setFocusable(false);

      JPanel mainPanel = new JPanel();
      mainPanel.add(textField1);
      mainPanel.add(new JButton(new AbstractAction("Exit") {

         @Override
         public void actionPerformed(ActionEvent evt) {
            JButton thisBtn = (JButton) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(thisBtn);
            win.dispose();
         }
      }));

      JFrame frame = new JFrame("Frame");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      // frame.setVisible(true);

      JTextField textField2 = new JTextField(10);
      JPanel mainPanel2 = new JPanel();
      mainPanel2.add(textField2);
      mainPanel2.add(new JButton(new AbstractAction("Submit") {

         @Override
         public void actionPerformed(ActionEvent evt) {
            JButton thisBtn = (JButton) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(thisBtn);
            win.dispose();
         }
      }));
      JDialog dialog = new JDialog(frame, "Dialog", ModalityType.APPLICATION_MODAL);
      dialog.getContentPane().add(mainPanel2);
      dialog.pack();
      dialog.setLocationRelativeTo(frame);
      dialog.setVisible(true);

      textField1.setText(textField2.getText());
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