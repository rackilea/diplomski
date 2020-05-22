import java.awt.*;
import javax.swing.*;
//https://stackoverflow.com/questions/35287367/changing-desktopicon-width-on-nimbus
public class DesktopIconWidthTest2 {
  public JComponent makeUI() {
    JDesktopPane desktop = new JDesktopPane();
    desktop.setDesktopManager(new DefaultDesktopManager() {
      @Override public void iconifyFrame(JInternalFrame f) {
        Rectangle r = this.getBoundsForIconOf(f);
        r.width = f.getDesktopIcon().getPreferredSize().width;
        f.getDesktopIcon().setBounds(r);
        super.iconifyFrame(f);
      }
    });
    desktop.add(createFrame("looooooooooooong title #", 1));
    desktop.add(createFrame("#", 0));
    return desktop;
  }
  private JInternalFrame createFrame(String t, int i) {
    JInternalFrame f = new JInternalFrame(t + i, true, true, true, true);
    f.setDesktopIcon(new JInternalFrame.JDesktopIcon(f) {
      @Override public Dimension getPreferredSize() {
        Dimension d = f.getMinimumSize();
        String title = f.getTitle();
        FontMetrics fm = getFontMetrics(getFont());
        //Magic Number 16: margin?
        d.width += SwingUtilities.computeStringWidth(fm, title) - 16;
        return d;
      }
    });
    f.setSize(200, 100);
    f.setVisible(true);
    f.setLocation(5 + 40 * i, 5 + 50 * i);
    return f;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        // MetalLookAndFeel: UIManager.put("DesktopIcon.width", 500);
      } catch (Exception e) {
        e.printStackTrace();
      }
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new DesktopIconWidthTest2().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}