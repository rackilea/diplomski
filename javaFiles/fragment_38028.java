public class TestTaskIcon {

  public static void main(String[] args) {

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {

        Image img = null;
        try {
          img = ImageIO.read(new File("floppy_disk_red.png"));
        } catch (IOException e) {
          e.printStackTrace();
        }
        TrayIcon ti = new TrayIcon(img, "Tooltip");
        ti.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            Rectangle bounds = getSafeScreenBounds(e.getPoint());
            JPopupMenu popup = new JPopupMenu();
            popup.add(new JLabel("hello"));

            Point point = e.getPoint();

            int x = point.x;
            int y = point.y;
            if (y < bounds.y) {
              y = bounds.y;
            } else if (y > bounds.y + bounds.height) {
              y = bounds.y + bounds.height;
            }
            if (x < bounds.x) {
              x = bounds.x;
            } else if (x > bounds.x + bounds.width) {
              x = bounds.x + bounds.width;
            }

            if (x + popup.getPreferredSize().width > bounds.x + bounds.width) {
              x = (bounds.x + bounds.width) - popup.getPreferredSize().width;
            }
            if (y + popup.getPreferredSize().height > bounds.y + bounds.height) {
              y = (bounds.y + bounds.height) - popup.getPreferredSize().height;
            }
            popup.setLocation(x, y);
            popup.setVisible(true);
          }
        });
        try {
          SystemTray.getSystemTray().add(ti);
        } catch (AWTException ex) {
          Logger.getLogger(TestTaskIcon.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    });
  }

  public static Rectangle getSafeScreenBounds(Point pos) {

    Rectangle bounds = getScreenBoundsAt(pos);
    Insets insets = getScreenInsetsAt(pos);

    bounds.x += insets.left;
    bounds.y += insets.top;
    bounds.width -= (insets.left + insets.right);
    bounds.height -= (insets.top + insets.bottom);

    return bounds;

  }

  public static Insets getScreenInsetsAt(Point pos) {
    GraphicsDevice gd = getGraphicsDeviceAt(pos);
    Insets insets = null;
    if (gd != null) {
      insets = Toolkit.getDefaultToolkit().getScreenInsets(gd.getDefaultConfiguration());
    }
    return insets;
  }

  public static Rectangle getScreenBoundsAt(Point pos) {
    GraphicsDevice gd = getGraphicsDeviceAt(pos);
    Rectangle bounds = null;
    if (gd != null) {
      bounds = gd.getDefaultConfiguration().getBounds();
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

    if (lstDevices.size() > 0) {
      device = lstDevices.get(0);
    } else {
      device = ge.getDefaultScreenDevice();
    }

    return device;

  }
}