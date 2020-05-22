import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class IsEdtDaemon {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
             JFrame frame = new JFrame();
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setVisible(true);

             System.out.printf("Is the current thread the EDT thread: %b%n",  SwingUtilities.isEventDispatchThread());
             System.out.printf("Is our EDT Thread a daemon thread:    %b%n",  Thread.currentThread().isDaemon());
         }
      });
   }
}