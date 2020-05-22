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
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public WhyNoDispose(String title) {
      super((JFrame)null, title);
      pack();
   }
}