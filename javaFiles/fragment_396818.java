import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JCustomFrame2 {

   public static String showMessageFrame(Window owner, String title,
         String message, String[] textOnButtons, ImageIcon icon) {
      final JDialog dialog = new JDialog(owner);
      StringBuilder sb = new StringBuilder();

      // make it application modal!
      dialog.setModalityType(ModalityType.APPLICATION_MODAL);
      JPanel panel = new JPanel();

      panel.setLayout(new GridBagLayout());
      panel.setBackground(Color.WHITE);

      GridBagConstraints c = new GridBagConstraints();
      c.anchor = GridBagConstraints.EAST;
      c.fill = GridBagConstraints.RELATIVE;
      c.gridx = 0;
      c.gridy = 0;
      c.insets = new Insets(5, 5, 5, 5);

      JLabel messageLabel = new JLabel(message);
      messageLabel.setFont(messageLabel.getFont().deriveFont(16.0f));

      panel.add(messageLabel, c);

      c.gridy = 1;
      c.gridx = 0;
      for (int i = 0; i < textOnButtons.length; i++) {
         JButton button = new JButton(textOnButtons[i]);
         button.addActionListener(new ButtonListener(sb));
         button.setFont(button.getFont().deriveFont(16.0f));
         panel.add(button, c);
         c.gridx++;
      }

      if (icon == null) {
         dialog.setIconImage(new BufferedImage(1, 1,
               BufferedImage.TYPE_INT_ARGB_PRE));
      } else {
         dialog.setIconImage(icon.getImage());
      }
      dialog.add(panel);
      dialog.setTitle(title);
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.pack();
      dialog.setVisible(true);

      return sb.toString();
   }

   private static class ButtonListener implements ActionListener {
      private StringBuilder sb;

      public ButtonListener(StringBuilder sb) {
         this.sb = sb;
      }


      @Override
      public void actionPerformed(ActionEvent e) {
         sb.append(e.getActionCommand());
         Component component = (Component) e.getSource();
         Window win = SwingUtilities.getWindowAncestor(component);
         if (win != null) {
            win.dispose();
         }
      }
   }

   public static String showMessageFrame(String title,
         String message, String[] textOnButtons, ImageIcon icon) {
      return showMessageFrame(null, title, message, textOnButtons, icon);
   }


   public static void main(String[] args) {
      String result = JCustomFrame2.showMessageFrame("Test Frame",
            "Do you really want to do this?", new String[] { "Hell No",
                  "Sure, Why Not" }, null);

      System.out.println(result);
   }
}