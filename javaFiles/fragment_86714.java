import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ButtonLists extends JPanel {
   private static final int ROWS = 6;
   private static final int COLS = 6;
   private List<JButton> allButtons = new ArrayList<JButton>();
   private List<JButton> evenButtons = new ArrayList<JButton>();

   public ButtonLists() {
      JPanel gridPanel = new JPanel(new GridLayout(ROWS, COLS));
      for (int i = 0; i < ROWS; i++) {
         for (int j = 0; j < COLS; j++) {
            int buttonInt = i * COLS + j;
            String buttonString = String.valueOf(buttonInt);
            JButton button = new JButton(buttonString);
            button.setEnabled(false);
            gridPanel.add(button);
            allButtons.add(button);
            if (buttonInt % 2 == 0) {
               evenButtons.add(button);
            }
         }
      }

      JPanel bottomPanel = new JPanel();
      bottomPanel.add(new JButton(new AbstractAction("Activate All") {

         @Override
         public void actionPerformed(ActionEvent e) {
            for (JButton btn : allButtons) {
               btn.setEnabled(true);
            }
         }
      }));
      bottomPanel.add(new JButton(new AbstractAction("Activate Even") {

         @Override
         public void actionPerformed(ActionEvent e) {
            for (JButton btn : allButtons) {
               btn.setEnabled(false);
            }
            for (JButton btn : evenButtons) {
               btn.setEnabled(true);
            }
         }
      }));
      bottomPanel.add(new JButton(new AbstractAction("Activate Odd") {

         @Override
         public void actionPerformed(ActionEvent e) {
            for (JButton btn : allButtons) {
               btn.setEnabled(true);
            }
            for (JButton btn : evenButtons) {
               btn.setEnabled(false);
            }
         }
      }));

      setLayout(new BorderLayout());
      add(gridPanel, BorderLayout.CENTER);
      add(bottomPanel, BorderLayout.PAGE_END);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("ButtonLists");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new ButtonLists());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}