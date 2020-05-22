Image toolkitImage = img.getScaledInstance(getWidth(), getHeight(), 
      Image.SCALE_SMOOTH);
int width = toolkitImage.getWidth(null);
int height = toolkitImage.getHeight(null);

// width and height are of the toolkit image
BufferedImage newImage = new BufferedImage(width, height, 
      BufferedImage.TYPE_INT_ARGB);
Graphics g = newImage.getGraphics();
g.drawImage(toolkitImage, 0, 0, null);
g.dispose();

// now use your new BufferedImage