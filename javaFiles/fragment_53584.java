Component c; // the component you would like to print to a BufferedImage
JFrame frame = new JFrame();
frame.setBackground(Color.WHITE);
frame.setUndecorated(true);
frame.getContentPane().add(c);
frame.pack();
BufferedImage bi = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
Graphics2D graphics = bi.createGraphics();
c.print(graphics);
graphics.dispose();
frame.dispose();