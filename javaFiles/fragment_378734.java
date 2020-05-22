import java.awt.*;
import javax.swing.*;

public class Foo2 {

   private static void createAndShowGui() {
      JLabel topLabel = new JLabel("Top Label", SwingConstants.LEFT);
      topLabel.setOpaque(true);
      topLabel.setBackground(Color.pink);

      JScrollPane scrollpane = new JScrollPane(
            Box.createRigidArea(new Dimension(400, 400)),
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

      topLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
      mainPanel.add(topLabel);
      scrollpane.setAlignmentX(Component.LEFT_ALIGNMENT);
      mainPanel.add(scrollpane);

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