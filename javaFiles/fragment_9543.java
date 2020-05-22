import java.awt.*;
import javax.swing.*;

public class Sam extends JFrame {
   public static final int COLUMN_COUNT = 4;

   public JButton btn_arr;
   public Container c;
   public JLabel[] lbl = new JLabel[COLUMN_COUNT];

   public Sam() {
      c = getContentPane();
      c.setLayout(new GridLayout(0, COLUMN_COUNT));

      for (int i = 0; i < lbl.length; i++) {
         lbl[i] = new JLabel("Column " + (i + 1));
         c.add(lbl[i]);
      }

   }

   public static void main(String[] args) {
      Sam x = new Sam();
      x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      x.pack();
      x.setLocationRelativeTo(null);
      x.setVisible(true);
      // x.setSize(7500,4500);
   }

}