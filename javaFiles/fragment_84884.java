public class TestTrayIcon {

    protected static final PopupFrame POPUP_FRAME = new PopupFrame();

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    TrayIcon trayIcon = new TrayIcon(ImageIO.read(new File("D:/DevWork/common/icons/iconex_v_bundle_png/iconexperience/v_collections_png/basic_foundation/16x16/plain/about.png")));
                    trayIcon.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                            Point pos = e.getLocationOnScreen();
                            Rectangle screen = getScreenBoundsAt(pos);

                            if (pos.x + POPUP_FRAME.getWidth() > screen.x + screen.width) {
                                pos.x = screen.x + screen.width - POPUP_FRAME.getWidth();
                            }
                            if (pos.x < screen.x) {
                                pos.x = screen.x;
                            }

                            if (pos.y + POPUP_FRAME.getHeight() > screen.y + screen.height) {
                                pos.y = screen.y + screen.height - POPUP_FRAME.getHeight();
                            }
                            if (pos.y < screen.y) {
                                pos.y = screen.y;
                            }

                            POPUP_FRAME.setLocation(pos);
                            POPUP_FRAME.setVisible(true);

                        }
                    });
                    SystemTray.getSystemTray().add(trayIcon);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static class PopupFrame extends JFrame {

        public PopupFrame() throws HeadlessException {
            setLayout(new BorderLayout());
            add(new JLabel("Hello world"));
            pack();
        }
    }

    public static Rectangle getScreenBoundsAt(Point pos) {
        GraphicsDevice gd = getGraphicsDeviceAt(pos);
        Rectangle bounds = null;

        if (gd != null) {
            bounds = gd.getDefaultConfiguration().getBounds();
            Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gd.getDefaultConfiguration());

            bounds.x += insets.left;
            bounds.y += insets.top;
            bounds.width -= (insets.left + insets.right);
            bounds.height -= (insets.top + insets.bottom);
        }
        return bounds;
    }

    public static GraphicsDevice getGraphicsDeviceAt(Point pos) {
        GraphicsDevice device = null;

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();

        ArrayList<GraphicsDevice> lstDevices = new ArrayList<GraphicsDevice>(lstGDs.length);

        for (GraphicsDevice gd : lstGDs) {
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            Rectangle screenBounds = gc.getBounds();

            if (screenBounds.contains(pos)) {
                lstDevices.add(gd);
            }
        }

        if (lstDevices.size() == 1) {
            device = lstDevices.get(0);
        }
        return device;
    }
}