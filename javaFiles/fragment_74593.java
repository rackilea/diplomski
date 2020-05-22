final JDialog d = new JDialog();
d.setSize(200, 200);
final Toolkit toolkit = Toolkit.getDefaultToolkit();
final Dimension screenSize = toolkit.getScreenSize();
final int x = (screenSize.width - d.getWidth()) / 2;
final int y = (screenSize.height - d.getHeight()) / 2;
d.setLocation(x, y);
d.setVisible(true);