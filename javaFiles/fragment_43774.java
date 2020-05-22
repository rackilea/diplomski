SystemTray tray = SystemTray.getSystemTray();
Image image = Toolkit.getDefaultToolkit().getImage("src/resources/busylogo.jpg");
final TrayIcon trayIcon = new TrayIcon(image);
try {
   tray.add(trayIcon);
} catch (AWTException e2) {
   e2.printStackTrace();
}