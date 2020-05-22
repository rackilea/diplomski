import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Board2 extends JPanel {
   private static final int TIMER_DELAY = 1000;

   private int counter = 0;
   private JLabel timerLabel = new JLabel("000");

   public Board2() {
      add(timerLabel);
      new Timer(TIMER_DELAY, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            counter++;
            timerLabel.setText(String.format("%03d", counter));
         }
      }).start();
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("Board2");
      frame.getContentPane().add(new Board2());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}