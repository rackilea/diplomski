URL url = new URL("https://maps.googleapis.com/maps/api/streetview?size=600x300&location=46.414382,10.013988");
BufferedImage streetView  = ImageIO.read(url);
JLabel label = new JLabel(new ImageIcon(streetView));
// JPanel panel = new JPanel();
// panel.add(label);

// code not needed:
// panel.setLocation(0,0);
// panel.setVisible(true);

// mainGuiComponent is a reference to a component on the main GUI
// or null if there is no main GUI.
JOptionPane.showMessageDialog(mainGuiComponent, label);