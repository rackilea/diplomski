public void addToTray()
{
    try 
    {
        try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        BufferedImage trayImg = ImageIO.read(new File("Geqo.png"));
        ImageIcon ii = new ImageIcon(trayImg);
        final TrayIcon trayIcon = new TrayIcon(ii.getImage(), "Geqo", null);

        JPopupMenu jpopup = new JPopupMenu();
        JMenuItem miExit = new JMenuItem("Exit");
        jpopup.add(miExit);

        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SystemTray.getSystemTray().remove(trayIcon);
                System.exit(0);
            }
        });

        trayIcon.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    jpopup.setLocation(e.getX(), e.getY());
                    jpopup.setInvoker(jpopup);
                    jpopup.setVisible(true);
                }
            }
        });

        trayIcon.setImageAutoSize(true);
        SystemTray.getSystemTray().add(trayIcon);
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
}