import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.plaf.synth.SynthTreeUI;

public final class DoubleClicksOnRightSideRowTest {
  private JComponent makeUI() {
    final JTree trProjects = new JTree();
    trProjects.setUI(new SynthTreeUI() {
      @Override public Rectangle getPathBounds(JTree tree, TreePath path) {
        if (tree != null && treeState != null) {
          Rectangle rect = treeState.getBounds(path, new Rectangle());
          if (rect != null) {
            Insets insets = tree.getInsets();
            rect.width = tree.getWidth();
            rect.y += insets.top;
          }
          return rect;
        }
        return null;
      }
    });
    trProjects.addMouseListener(new MouseAdapter() {
      @Override public void mousePressed(MouseEvent e) {
        int selRow = trProjects.getRowForLocation(e.getX(), e.getY());
        TreePath selPath = trProjects.getPathForLocation(e.getX(), e.getY());
        if (selRow != -1 && e.getClickCount() == 2 && selPath != null) {
          Object selectedNode = selPath.getLastPathComponent();
          System.out.println("do something else");
        }
      }
    });
    return new JScrollPane(trProjects);
  }
  public static void main(String... args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
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
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new DoubleClicksOnRightSideRowTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}