public static void createSystemTrayIcon() {

    if (SystemTray.isSupported()) {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().getImage(
            System.getenv("MY_PROGRAM_HOME") + "game.ico"
        );

        PopupMenu popup = new PopupMenu();

        final MenuItem menuExit = new MenuItem("Quit");

        MouseListener mouseListener =
            new MouseListener() {
                public void mouseClicked(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
                public void mouseExited(MouseEvent e) {}
                public void mousePressed(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {}
        };

        ActionListener exitListener =
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Runtime r = Runtime.getRuntime();
                    System.out.println("Exiting...");
                    r.exit(0);
                }
            };

        menuExit.addActionListener(exitListener);
        popup.add(menuExit);

        final TrayIcon trayIcon = new TrayIcon(image, "My program", popup);

        ActionListener actionListener =
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    trayIcon.displayMessage(
                        "My program ",
                        "version: blahblah",
                        TrayIcon.MessageType.INFO
                    );
            }
        };

        trayIcon.setImageAutoSize(true);
        trayIcon.addActionListener(actionListener);
        trayIcon.addMouseListener(mouseListener);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.err.println("TrayIcon could not be added.");
        }

    } else {
        //  System Tray is not supported
    }
}