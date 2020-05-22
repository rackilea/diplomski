// Create new buffered image
BufferedImage shifted = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
// Create the graphics
Graphics2D g = shifted.createGraphics();
// Draw original with shifted coordinates
g.drawImage(original, shiftx, shifty, null);