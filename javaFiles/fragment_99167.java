import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;

public class DemoLookAndFeel2 extends JFrame {
  private JMenuBar menuBar = new JMenuBar();
  private JMenu arrowMenuOne = new JMenu("Root Menu 1");
  private JMenu arrowMenuTwo = new JMenu("Root Menu 2");

  static {
    UIManager.put("MenuItem.selectionForeground", Color.MAGENTA);
    UIManager.put("MenuItem.foreground", Color.MAGENTA);
    UIManager.put("Menu.selectionForeground", Color.MAGENTA);
    UIManager.put("Menu.foreground", Color.MAGENTA);
    // or: UIManager.put("Menu.arrowIcon", new MenuArrowIcon());
  }

  public void init() {
    setJMenuBar(menuBar);
    addSubMenus(arrowMenuOne, 5);
    addSubMenus(arrowMenuTwo, 3);

    menuBar.add(arrowMenuOne);
    menuBar.add(arrowMenuTwo);

    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setSize(800, 800);
    // this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  public void addSubMenus(JMenu parent, int number) {
    for (int i = 1; i <= number; i++) {
      JMenu menu = new JMenu("Sub Menu " + i);
      parent.add(menu);

      addSubMenus(menu, number - 1);
      addMenuItems(menu, number);
    }
  }

  public void addMenuItems(JMenu parent, int number) {
    for (int i = 1; i <= number; i++) {
      parent.add(new JMenuItem("Item " + i));
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override public void run() {
        MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme() {
          @Override public ColorUIResource getMenuSelectedForeground() {
            return new ColorUIResource(Color.MAGENTA);
          };
        });
        DemoLookAndFeel2 demo = new DemoLookAndFeel2();
        demo.init();
      }
    });
  }
}