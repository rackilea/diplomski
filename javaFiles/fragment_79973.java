public static void showNotification(String title, String msg,
            String location) {
    if (SystemTray.isSupported()) {
        trayIcon.displayMessage(title, msg, TrayIcon.MessageType.INFO);
        SystemTrayGUI.location = location;// this sets the location that should be opened when balloon is clicked.

    }
}