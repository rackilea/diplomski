import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogEg {
   private static void createAndShowGUI() {
      MainPanelGen mainPanelGen = new MainPanelGen();

      JFrame frame = new JFrame("DialogEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanelGen.getMainPanel());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }

}

class MainPanelGen {
   private JPanel mainPanel = new JPanel();
   private JTextField field = new JTextField(10);
   private JButton btn = new JButton(new BtnActn());
   private JDialog dialog;
   private DialogPanel dialogPanel = new DialogPanel();

   public MainPanelGen() {
      mainPanel.add(field);
      mainPanel.add(btn);

      field.setEditable(false);
      field.setFocusable(false);
   }

   public JPanel getMainPanel() {
      return mainPanel;
   }

   private class BtnActn extends AbstractAction {
      BtnActn() {
         super("Button");
      }

      @Override
      public void actionPerformed(ActionEvent arg0) {
         if (dialog == null) {
            Window win = SwingUtilities.getWindowAncestor(mainPanel);
            if (win != null) {
               dialog = new JDialog(win, "My Dialog",
                     Dialog.ModalityType.APPLICATION_MODAL);
               dialog.getContentPane().add(dialogPanel);
               dialog.pack();
               dialog.setLocationRelativeTo(null);
            }
         }
         dialog.setVisible(true); // here the modal dialog takes over
         System.out.println   (dialogPanel.getFieldText());
         field.setText(dialogPanel.getFieldText());
      }
   }
}

class DialogPanel extends JPanel {
   private JTextField field = new JTextField(10);
   private JButton exitBtn = new JButton(new ExitBtnAxn("Exit"));

   public DialogPanel() {
      add(field);
      add(exitBtn);
   }

   public String getFieldText() {
      return field.getText();
   }

   private class ExitBtnAxn extends AbstractAction {

      public ExitBtnAxn(String name) {
         super(name);
      }

      @Override
      public void actionPerformed(ActionEvent arg0) {
         Window win = SwingUtilities.getWindowAncestor(DialogPanel.this);
         if (win != null) {
            win.dispose();
         }
      }
   }
}