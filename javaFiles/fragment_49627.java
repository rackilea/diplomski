import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class DemoClass2 extends JPanel {
   // constants
   private static final String TITLE = "Message";
   private static final float LABEL_POINTS = 24f;
   private static final int L_GAP = 15;
   private static final int B_GAP = 25;

   // static poor man's singlton instance
   private static DemoClass2 demoClass2;
   private JDialog dialog = new JDialog();
   private JLabel label = new JLabel("", SwingConstants.CENTER);

   public DemoClass2() {
      dialog.setModal(true);
      dialog.setTitle(TITLE);

      label.setFont(label.getFont().deriveFont(Font.BOLD, LABEL_POINTS));
      label.setBorder(BorderFactory.createEmptyBorder(L_GAP, L_GAP, L_GAP, L_GAP));

      JPanel btnPanel = new JPanel(new GridBagLayout());
      btnPanel.setBorder(BorderFactory.createEmptyBorder(B_GAP, B_GAP, B_GAP, B_GAP));
      btnPanel.add(new JButton(new DisposeAction("Close", KeyEvent.VK_C)));

      setLayout(new BorderLayout());
      //setBorder(border);
      add(label, BorderLayout.PAGE_START);
      add(btnPanel, BorderLayout.CENTER);

      dialog.getContentPane().add(this);
   }

   private void setMessage(String message) {
      label.setText(message);
   }

   private void display() {
      dialog.setResizable(false);
      dialog.pack();
      dialog.setLocationRelativeTo(null);
      dialog.setVisible(true);
   }

   public void setMessageAndDisplay(String message) {
      setMessage(message);
      display();
   }

   public static void displayMessage(String message) {
      if (demoClass2 == null) {
         demoClass2 = new DemoClass2();
      }
      demoClass2.setMessageAndDisplay(message);
   }

   private class DisposeAction extends AbstractAction {
      public DisposeAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         Component c = (Component) e.getSource();
         if (c == null) {
            return;
         }
         Window win = SwingUtilities.getWindowAncestor(c);
         if (win == null) {
            return;
         }
         win.dispose();         
      }
   }

   private static void createAndShowGui() {
      DemoClass2.displayMessage("Fubars Rule!!!");

      DemoClass2.displayMessage("This is a bit of a longer message. The dialog should get bigger.");
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}