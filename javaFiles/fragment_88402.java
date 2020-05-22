import java.awt.Dimension;
import javax.swing.*;

public class DialogNoFocus {
   public DialogNoFocus() {
      // TODO Auto-generated constructor stub
   }

   private static void createAndShowGui() {
      DialogNoFocus mainPanel = new DialogNoFocus();

      JFrame frame = new JFrame("JFrame");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(Box.createRigidArea(new Dimension(400, 300)));
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);

      JDialog dialog = new JDialog(frame, "JDialog", false);
      dialog.getContentPane().add(Box.createRigidArea(new Dimension(500, 100)));
      int x = frame.getLocation().x;
      int y = frame.getLocation().y + frame.getHeight();
      dialog.setLocation(x, y);
      dialog.pack();
      dialog.setFocusableWindowState(false);
      dialog.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}