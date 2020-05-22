import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class FlagEg extends JPanel {
   private static final int LABEL_COUNT = 3;
   private JLabel[] labels = new JLabel[LABEL_COUNT];
   private boolean[] flags = new boolean[LABEL_COUNT];

   public FlagEg() {
      setLayout(new GridLayout(1, 0, 20, 0));
      setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

      // panel mouse listener
      addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent arg0) {
            inactivateAll();
         }
      });

      MouseListener labelsMouseListener = new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent mouseEvt) {
            myMousePressed(mouseEvt);
         }
      };

      // create JLabels and add MouseListener
      for (int i = 0; i < labels.length; i++) {
         labels[i] = new JLabel("Label " + (i + 1));
         labels[i].addMouseListener(labelsMouseListener);
         labels[i].setOpaque(true);
         labels[i].setBorder(BorderFactory.createLineBorder(Color.black));
         add(labels[i]);
      }
   }

   private void inactivateAll() {
      for (int i = 0; i < labels.length; i++) {
         labels[i].setBackground(null);
         flags[i] = false;
      }
   }

   private void myMousePressed(MouseEvent mouseEvt) {
      JLabel label = (JLabel) mouseEvt.getSource();

      // which label was pressed?
      int index = -1;
      for (int i = 0; i < labels.length; i++) {
         if (label == labels[i]) {
            index = i;
         }
      }

      // check if first label and then third pressed:
      if (flags[0] && index == 2) {
         System.out.println("first and then third label pressed!");
      }

      // reset all labels and flags to initial state
      inactivateAll();

      // set pressed label background color and set flag of label just pressed
      labels[index].setBackground(Color.pink);
      flags[index] = true;

   }

   private static void createAndShowGui() {
      FlagEg mainPanel = new FlagEg();

      JFrame frame = new JFrame("Flag Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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