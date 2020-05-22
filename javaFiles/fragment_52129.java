BufferedImage a = ImageIO.read(new File(filePath, "a.png"));
BufferedImage b = ImageIO.read(new File(filePath, "b.png"));
BufferedImage c = new BufferedImage(a.getWidth(), a.getHeight(), BufferedImage.TYPE_INT_ARGB);

Graphics g = c.getGraphics();
g.drawImage(a, 0, 0, null);
g.drawImage(b, 0, 0, null);