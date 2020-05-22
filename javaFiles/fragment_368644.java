import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public final class SystemTrayTest {
  public static void main(String... args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    final JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    frame.setResizable(false);
    frame.setSize(320, 240);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    if (!SystemTray.isSupported()) {
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      return;
    }
    final SystemTray tray = SystemTray.getSystemTray();
    BufferedImage i= new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = i.createGraphics();
    g.setColor(Color.RED);
    g.fillRect(2, 2, 12, 12);
    g.dispose();
    final PopupMenu popup = new PopupMenu();
    final TrayIcon icon   = new TrayIcon(i, "TRAY", popup);

    Handler h = new Handler(tray, icon);
    frame.addWindowStateListener(h);
    frame.addWindowListener(h);

    MenuItem item1 = new MenuItem("OPEN");
    item1.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        frame.setVisible(true);
        tray.remove(icon);
      }
    });
    MenuItem item2 = new MenuItem("EXIT");
    item2.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        tray.remove(icon);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.dispose();
        //System.exit(0);
      }
    });
    popup.add(item1);
    popup.add(item2);
  }
}

class Handler extends WindowAdapter {
  private final SystemTray tray;
  private final TrayIcon icon;
  public Handler(SystemTray tray, TrayIcon icon) {
    super();
    this.tray = tray;
    this.icon = icon;
  }
  private void addTrayIconDisposeFrame(JFrame frame) {
    try {
      tray.add(icon);
      frame.dispose();
      //frame.setVisible(false);
    } catch (AWTException ex) {
      ex.printStackTrace();
    }
  }
  @Override public void windowStateChanged(WindowEvent e) {
    System.out.println("ICONIFIED");
    if (e.getNewState() == Frame.ICONIFIED) {
      addTrayIconDisposeFrame((JFrame) e.getSource());
    }
  }
  @Override public void windowClosing(WindowEvent e) {
    System.out.println("windowClosing");
    addTrayIconDisposeFrame((JFrame) e.getSource());
  }
}