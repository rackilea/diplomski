BufferedImage newImage = new BufferedImage(
    oldImage.getWidth(), oldImage.getHeight, BufferedImage.TYPE_INT_ARGB);
Graphics2D g2d = newImage.createGraphics();
g2d.translate(0, newImage.getHeight());
g2d.scale(1, -1);
g2d.drawImage(oldImage, 0, 0, null);
g2d.dispose();