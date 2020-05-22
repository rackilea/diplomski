import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TabHeightTest {
  public JComponent makeUI() {
    JTabbedPane tabbedPane = new JTabbedPane(
      JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
    tabbedPane.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
      @Override protected int calculateTabHeight(
        int tabPlacement, int tabIndex, int fontHeight) {
        return 32;
      }
      @Override protected void paintTab(
        Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,
        Rectangle iconRect, Rectangle textRect) {
        if(tabIndex==0) {
          rects[tabIndex].height = 20 + 1;
          rects[tabIndex].y = 32 - rects[tabIndex].height + 1;
        } else if(tabIndex==1) {
          rects[tabIndex].height = 26 + 1;
          rects[tabIndex].y = 32 - rects[tabIndex].height + 1;
        }
        super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
      }
    });
    tabbedPane.addTab("000", new JLabel("aaaaaaaaaaa"));
    tabbedPane.addTab("111", new JScrollPane(new JTree()));
    tabbedPane.addTab("222", new JSplitPane());

    return tabbedPane;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.getContentPane().add(new TabHeightTest().makeUI());
    frame.setSize(320, 240);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}