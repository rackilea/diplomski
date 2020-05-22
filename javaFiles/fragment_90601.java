import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class IntroPanel extends JPanel {
   private static final int DELAY_TIME = 5;
   protected static final Color FG_COLOR = Color.blue;
   private List<JLabel> labelList = new ArrayList<JLabel>();
   private List<Color> colorList = new ArrayList<>();

   public IntroPanel() {
      for (int i = 0; i < 255; i++) {
         colorList.add(new Color(0, 0, 255, i));
      }
      for (int i = 0; i < 255; i++) {
         colorList.add(new Color(0, 0, 255, 255 - i));
      }

      setLayout(new GridLayout(0, 1));

      JLabel label1 = new JLabel("Label 1");
      label1.setFont(label1.getFont().deriveFont(Font.ITALIC, 24));
      add(label1);
      labelList.add(label1);
      JLabel label2 = new JLabel("Label 2");
      label2.setFont(label2.getFont().deriveFont(Font.ITALIC, 24));
      add(label2);
      labelList.add(label2);
      JLabel label3 = new JLabel("Label 3");
      label3.setFont(label3.getFont().deriveFont(Font.PLAIN, 10));
      add(label3);
      labelList.add(label3);

      new Timer(DELAY_TIME, new ActionListener() {
         private int index = 0;

         @Override
         public void actionPerformed(ActionEvent evt) {
            if (index < colorList.size()) {
               for (JLabel label : labelList) {
                  label.setForeground(colorList.get(index));
               }
               index++;
            } else {
               ((Timer)evt.getSource()).stop();
            }
         }
      }).start();
   }

   private static void createAndShowGUI() {
      IntroPanel paintEg = new IntroPanel();

      JFrame frame = new JFrame("IntroPanel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(paintEg);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}