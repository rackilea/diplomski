import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Foo  extends JPanel {
   private JButton btnA = new JButton("Button A");
   private JButton btnB = new JButton("Button B");
   private JButton btnC = new JButton("Button C");

   public Foo() {
      btnA.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("button A Action");
         }
      });
      btnB.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("button B Action");
         }
      });
      btnC.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            System.out.println("button C Action");
         }
      });

      add(btnA);
      add(btnB);
      add(btnC);
   }

   private static void createAndShowGui() {
      Foo mainPanel = new Foo();

      JFrame frame = new JFrame("Foo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
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