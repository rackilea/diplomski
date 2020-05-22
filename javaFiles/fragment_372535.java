BufferedImage buffImg = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
Graphics2D g2 = buffImg.createGraphics();

// ... other code we need

BufferedImage img= new BufferedImage(buffImg.getWidth(), buffImg.getHeight(), BufferedImage.TYPE_INT_RGB);
Graphics2D g2d = img.createGraphics();
g2d.drawImage(buffImg, 0, 0, null);
g2d.dispose();