Dimension d = component.getSize();
BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
Graphics2D g2d = image.createGraphics();
component.print( g2d );
g2d.dispose();
ImageIO.write(image, ".jpg", new File(...));