import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Foo {
   private static void createAndShowGui() {
      Frame1 frame = new Frame1();
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

// I almost never extend JFrame
class Frame1 extends JFrame {
   private Panel1 panel1 = new Panel1();
   private JLabel label = new JLabel(" ", SwingConstants.CENTER);

   public Frame1() {
      super("Foo");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      add(panel1, BorderLayout.CENTER);
      add(label, BorderLayout.SOUTH);
      pack();
      setLocationByPlatform(true);

      panel1.addButton1ActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            label.setText("Button pressed");
         }
      });
   }
}

class Panel1 extends JPanel {
   private JButton button1 = new JButton("Button");

   public Panel1() {
      add(button1);
   }

   public void addButton1ActionListener(ActionListener listener) {
      button1.addActionListener(listener);
   }
}