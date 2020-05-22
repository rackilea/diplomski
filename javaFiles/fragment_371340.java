BufferedImage tempImage = new BufferedImage(imagePane.getWidth(), imagePane.getHeight(), BufferedImage.TYPE_INT_ARGB);
Graphics2D g = tempImage.createGraphics();

imagePane.printAll(g);

ImageIO.write(tempImage, "png", new File("C:\\save.png"));