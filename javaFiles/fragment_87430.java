import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogExample {
   private static void createAndShowGui() {
      JFrame frame = new JFrame("Dialog Example");
      MainPanel mainPanel = new MainPanel(frame);

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

class MainPanel extends JPanel {
   private InputPanel inputPanel = new InputPanel();
   private JTextField responseField = new JTextField(10);
   private JDialog inputDialog;
   private JFrame inputFrame;

   public MainPanel(final JFrame mainJFrame) {
      responseField.setEditable(false);
      responseField.setFocusable(false);

      add(responseField);
      add(new JButton(new AbstractAction("Open Input Modal Dialog") {

         @Override
         public void actionPerformed(ActionEvent e) {
            if (inputDialog == null) {
               inputDialog = new JDialog(mainJFrame, "Input Dialog", true);
            }
            inputDialog.getContentPane().add(inputPanel);
            inputDialog.pack();
            inputDialog.setLocationRelativeTo(mainJFrame);
            inputDialog.setVisible(true);  

            // all code is now suspended at this point until the dialog has been 
            // made invisible

            if (inputPanel.isConfirmed()) {
               responseField.setText(inputPanel.getInputFieldText());
               inputPanel.setConfirmed(false);
            }
         }
      }));
      add(new JButton(new AbstractAction("Open Input JFrame") {

         @Override
         public void actionPerformed(ActionEvent e) {
            if (inputFrame == null) {
               inputFrame = new JFrame("Input Frame");
            }

            inputFrame.getContentPane().add(inputPanel);
            inputFrame.pack();
            inputFrame.setLocationRelativeTo(mainJFrame);
            inputFrame.setVisible(true);  

            // all code continues whether or not the inputFrame has been
            // dealt with or not.

            if (inputPanel.isConfirmed()) {
               responseField.setText(inputPanel.getInputFieldText());
               inputPanel.setConfirmed(false);
            }

         }
      }));
   }
}

class InputPanel extends JPanel {
   private JTextField inputField = new JTextField(10);
   private JButton confirmBtn = new JButton("Confirm");
   private JButton cancelBtn = new JButton("Cancel");
   private boolean confirmed = false;

   public InputPanel() {
      add(inputField);
      add(confirmBtn);
      add(cancelBtn);

      confirmBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            confirmed = true;
            Window win = SwingUtilities.getWindowAncestor(InputPanel.this);
            win.setVisible(false);
         }
      });
      cancelBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            confirmed = false;
            Window win = SwingUtilities.getWindowAncestor(InputPanel.this);
            win.setVisible(false);
         }
      });
   }

   public boolean isConfirmed() {
      return confirmed;
   }

   public void setConfirmed(boolean confirmed) {
      this.confirmed = confirmed;
   }

   public String getInputFieldText() {
      return inputField.getText();
   }
}