import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GUIProblem extends JFrame {
   public GUIProblem() {
      // setSize(640, 480);

      JPanel panel = new JPanel();
      getContentPane().add(panel, BorderLayout.CENTER);

      final JTextArea textArea = new JTextArea(20, 50);
      textArea.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent mEvt) {
            int i = 0;
            int timerDelay = 200;
            new Timer(timerDelay, new ActionListener() {
               int count = 0;
               private final int MAX_COUNT = 10;
               @Override
               public void actionPerformed(ActionEvent e) {
                  if (count >= MAX_COUNT) {
                     ((Timer) e.getSource()).stop(); // stop the timer
                     return;
                  }
                  textArea.append("Count is: " + count + "\n");
                  count++;
               }
            }).start();
         }
      });

      panel.add(new JScrollPane(textArea));
   }

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            GUIProblem gui = new GUIProblem();
            gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            gui.pack();
            gui.setLocationRelativeTo(null);
            gui.setVisible(true);
         }
      });
      JOptionPane.showMessageDialog(null, "Click the textArea!");
   }
}