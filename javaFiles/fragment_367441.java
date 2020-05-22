public static void main(String[] args) throws URISyntaxException {
    final URI uri = new URI("http://java.sun.com");
    class OpenUrlAction implements ActionListener {
      @Override public void actionPerformed(ActionEvent e) {
        open(uri);
      }
    }
    JFrame frame = new JFrame("Links");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(100, 400);
    Container container = frame.getContentPane();
    container.setLayout(new GridBagLayout());
    JButton button = new JButton();
    button.setText("<HTML>Click the <FONT color=\"#000099\"><U>link</U></FONT>"
        + " to go to the Java website.</HTML>");
    button.setHorizontalAlignment(SwingConstants.LEFT);
    button.setBorderPainted(false);
    button.setOpaque(false);
    button.setBackground(Color.WHITE);
    button.setToolTipText(uri.toString());
    button.addActionListener(new OpenUrlAction());
    container.add(button);
    frame.setVisible(true);
  }

  private static void open(URI uri) {
    if (Desktop.isDesktopSupported()) {
      try {
        Desktop.getDesktop().browse(uri);
      } catch (IOException e) { /* TODO: error handling */ }
    } else { /* TODO: error handling */ }
  }