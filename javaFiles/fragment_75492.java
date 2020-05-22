double scaleWidth = (double)sizeX / (double)image.getWidth(this);
double scaleHeight = (double)sizeY / (double)image.getHeight(this);
BufferedImage img = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_ARGB);
Graphics2D g2d = img.createGraphics();
AffineTransform at = new AffineTransform();
at.scale(scaleWidth, scaleHeight);
at.rotate(Math.toRadians(degrees), image.getWidth(this) / 2d, image.getHeight(this) / 2d);
g2d.setTransform(at);
g2d.drawImage(image, sizeX / 2, sizeY / 2, null);
g2d.dispose();

// And finally, the result...
g.drawImage(img, x, y, null);