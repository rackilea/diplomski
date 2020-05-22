JLabel srcLabel = new JLabel();
JLabel dest = new JLabel();
BufferedImage img = new BufferedImage(srcLabel.getWidth(), srcLabel.getHeight(), BufferedImage.TYPE_INT_ARGB);
Graphics2D g2d = img.createGraphics();
srcLabel.printAll(g2d);
g2d.dispose();
dest.setIcon(new ImageIcon(img));