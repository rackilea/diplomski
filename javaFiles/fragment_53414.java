import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class FlagEg2 extends JPanel {
   private static final int LABEL_COUNT = 3;
   private JLabel[] labels = new JLabel[LABEL_COUNT];

   private boolean label1Flag = false;

   public FlagEg2() {
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
         label1Flag = false;
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

      if (label1Flag) {
         if (index == 1) {
            System.out.println("Label 1 and label 2 pressed");
         } else if (index == 2) {
            System.out.println("Label 1 and label 3 pressed");
         }

      }

      // reset all labels and flags to initial state
      inactivateAll();

      // if label1, then activate it
      if (index == 0) {
         labels[0].setBackground(Color.pink);
         label1Flag = true;
      }

   }

   private static void createAndShowGui() {
      FlagEg2 mainPanel = new FlagEg2();

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