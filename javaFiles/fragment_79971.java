public class Main {
  static Image image = Toolkit.getDefaultToolkit().getImage("images/tray.gif");

  static TrayIcon trayIcon = new TrayIcon(image, "Tester2");

  public static void main(String[] a) throws Exception {
    if (SystemTray.isSupported()) {
      SystemTray tray = SystemTray.getSystemTray();

      trayIcon.setImageAutoSize(true);
      trayIcon.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("In here");
          trayIcon.displayMessage("Tester!", "Some action performed", TrayIcon.MessageType.INFO);
        }
      });

      try {
        tray.add(trayIcon);
      } catch (AWTException e) {
        System.err.println("TrayIcon could not be added.");
      }
    }
  }
}