import java.awt.*;
import javax.swing.*;

public class Foo003 {

   private static void createAndShowGui() {
      JButton btnA = new JButton("A");
      JButton btnB = new JButton("B");

      btnA.setPreferredSize(new Dimension(50, 25));
      btnB.setPreferredSize(new Dimension(100, 25));

      JPanel btnAPanel = new JPanel(); // uses default FlowLayout.CENTER
      JPanel btnBPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      btnAPanel.add(btnA);
      btnBPanel.add(btnB);

      JPanel topPanel = new JPanel(new GridLayout(1, 0));
      topPanel.add(new JLabel("")); // empty placeholder label
      topPanel.add(btnAPanel);
      topPanel.add(btnBPanel);

      JPanel mainPanel = new JPanel(new BorderLayout());
      mainPanel.add(topPanel, BorderLayout.NORTH);

      mainPanel.setPreferredSize(new Dimension(400, 300));

      JFrame frame = new JFrame("Foo003");
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