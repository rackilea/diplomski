import java.awt.*;
import javax.sound.midi.*;
import javax.swing.*;

public class MidiFoo {
   public static void main(String args[]) {

      new Thread(new Runnable() {
         public void run() {
            try {
               Receiver receiver = MidiSystem.getReceiver();
            } catch (MidiUnavailableException e) {
               e.printStackTrace();
            }
         }
      }).start();

      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JFrame frame = new JFrame("here's a frame");
            Dimension d = new Dimension(500, 500);
            frame.setSize(d);
            frame.setPreferredSize(d);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         }
      });
   }
}