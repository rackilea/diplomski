import java.awt.*;
import javax.swing.*;

public class NimbusDrawVerticalLinesTest {
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      try {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
      } catch (Exception e) {
        e.printStackTrace();
      }
      // UIManager.put("Tree.drawVerticalLines", true);
      UIManager.getLookAndFeelDefaults().put("Tree.drawVerticalLines", true);
      UIManager.put("Tree.drawHorizontalLines", true);
      UIManager.put("Tree.linesStyle", "dashed");

      JTree tree = new JTree();
//       UIDefaults d = new UIDefaults();
//       d.put("Tree.drawVerticalLines", Boolean.TRUE);
//       tree.putClientProperty("Nimbus.Overrides", d);

      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new JScrollPane(tree));
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}