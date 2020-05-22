import java.awt.event.*;
import java.util.concurrent.ExecutionException;
import javax.swing.*;

public class FooGui {
   private static int threads = 0;

   private static void createAndShowUI() {
      final JLabel label = new JLabel("      ");
      JButton button = new JButton("Button");
      button.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            new SwingWorker<String, Void>() {

               @Override
               protected String doInBackground() throws Exception {
                  return doCalculation();
               }

               @Override
               protected void done() {
                  try {
                     label.setText(get());
                  } catch (InterruptedException e) {
                     System.out.println("thread was interrupted");
                  } catch (ExecutionException e) {
                     System.out.println("there was an ExecutionException");
                  }
               }
            }.execute();
         }
      });
      JPanel panel = new JPanel();
      panel.add(button);
      panel.add(label);

      JFrame frame = new JFrame("FooGui");
      frame.getContentPane().add(panel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   private static String doCalculation() {
      for (int i = 0; i < 5000000; i++) {
         Math.pow(3.14, i);
      }
      return threads++ + "";
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {

         @Override
         public void run() {
            createAndShowUI();
         }
      });
   }
}