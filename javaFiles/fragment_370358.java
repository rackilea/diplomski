if (SystemTray.isSupported()) {
     SystemTray tray = SystemTray.getSystemTray();
     Image image = ...;
     trayIcon = new TrayIcon(image, "Tray Demo");
     try {
         tray.add(trayIcon);
     } catch (AWTException e) {
         System.err.println(e);
     }
}