BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

Graphics g = image.getGraphics();

// Pass this graphics object to your application to perform the drawing         
g.setColor(Color.red);
g.drawRoundRect(10, 10, 20, 20, 5, 5);

// save it to disk
ImageIO.write(image, "png", new File("test.png"));