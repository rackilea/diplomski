import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public final class BasicTabbedPaneColorTest {
  private JComponent makeUI() {
    //UIManager.put("TabbedPane.contentBorderInsets",  new Insets(10, 10, 10, 10));
    //UIManager.put("TabbedPane.contentBorderInsets",  new Insets(0, 10, 10, 10));

    UIManager.put("TabbedPane.contentAreaColor", Color.GREEN);
    UIManager.put("TabbedPane.highlight",        Color.RED);

    JTabbedPane tabs = new JTabbedPane();
    tabs.setUI(new BasicTabbedPaneUI());
    //tabs.setBackground(Color.ORANGE);
    //tabs.setOpaque(true);

    tabs.addTab("JTable", new JScrollPane(new JTable(20, 3)));
    tabs.addTab("JTree",  new JScrollPane(new JTree()));
    return tabs;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new BasicTabbedPaneColorTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}