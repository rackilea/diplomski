int type = BufferedImage.TYPE_INT_ARGB;
image = new BufferedImage(w, h, type);
Graphics2D g2d = image.createGraphics();
g2d.setColor(Color.GREEN);
g2d.fillRect(0, 0, w, h);
g2d.dispoe();