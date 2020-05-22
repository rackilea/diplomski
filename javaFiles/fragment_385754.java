import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowListenerFun {
   public static void main(String[] args) {
      JPanel panel = new JPanel();
      panel.add(new JTextField(10));
      panel.add(new JButton("button"));
      JFrame frame = new JFrame("Bad Frame");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

      frame.addWindowListener(new WindowAdapter() {

         @Override
         public void windowIconified(WindowEvent wEvt) {
            ((JFrame)wEvt.getSource()).dispose();
         }

         @Override
         public void windowDeactivated(WindowEvent wEvt) {
            ((JFrame)wEvt.getSource()).dispose();
         }

      });
   }
}