import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Temp {
   private JPanel  panel1;
   private JButton button1;

   JFrame          tempWindow = new JFrame("TempWindow");

   private Temp() {
      button1 = new JButton("Button");
      tempWindow.add(button1);
      button1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            tempWindow.setVisible(false);
            JOptionPane.showMessageDialog(null, "Hello World");
         }
      });
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new Temp().start());

   }

   public void start() {
      tempWindow.setLocationRelativeTo(null); // this line set the window in the
                                              // center of the screen
      tempWindow.setPreferredSize(new Dimension(500, 500));
      tempWindow.setDefaultCloseOperation(tempWindow.EXIT_ON_CLOSE);
      tempWindow.pack();
      tempWindow.setLocationRelativeTo(null); // centers on screen
      tempWindow.setVisible(true);

   }

}