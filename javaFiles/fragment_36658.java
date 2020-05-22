import java.awt.*;
import javax.swing.*;
import javax.swing.Painter;

public class TreeCellPainterTest {
  public JComponent makeUI() {
    //UIDefaults d = new UIDefaults();
    UIDefaults d = UIManager.getLookAndFeelDefaults();
    d.put("Tree:TreeCell[Enabled+Selected].backgroundPainter", new Painter<JComponent>() {
      @Override public void paint(Graphics2D g, JComponent c, int w, int h) {
        g.setColor(Color.GREEN);
        g.fillRoundRect(0, 0, w - 1, h - 1, 15, 15);
      }
    });
    d.put("Tree:TreeCell[Focused+Selected].backgroundPainter", new Painter<JComponent>() {
      @Override public void paint(Graphics2D g, JComponent c, int w, int h) {
        g.setColor(Color.RED);
        g.fillRect(0, 0, w, h);
      }
    });

    JTree tree = new JTree();
    tree.putClientProperty("Nimbus.Overrides", d);
    tree.putClientProperty("Nimbus.Overrides.InheritDefaults", false);

    JPanel p = new JPanel(new GridLayout(1, 2));
    p.add(new JScrollPane(new JTree()));
    p.add(new JScrollPane(tree));
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    try {
      for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(laf.getName())) {
          UIManager.setLookAndFeel(laf.getClassName());
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.getContentPane().add(new TreeCellPainterTest().makeUI());
    frame.setSize(320, 240);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}