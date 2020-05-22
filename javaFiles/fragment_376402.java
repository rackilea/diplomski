BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

Graphics g = image.getGraphics();
g.translate(-100, -100);

c.paintComponent(g);

g.dispose();