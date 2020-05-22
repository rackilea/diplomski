import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JDialog;

public class WhyNoDispose extends JDialog {
   public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            try {
               WhyNoDispose frame = new WhyNoDispose("my title");
               frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
               JFrame win = (JFrame) frame.getOwner();
               win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
               win.dispose();
               // System.exit(0);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public WhyNoDispose(String title) {
      super(new JFrame(title), ModalityType.APPLICATION_MODAL);
      pack();
   }
}