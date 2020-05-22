BufferedImage merged = new BufferedImage(bottomImg.getWidth(), bottomImg.getHeight(), BufferedImage.TYPE_INT_ARGB);
Graphics2D g2d = master.createGraphics();
g2d.drawImage(bottomImg, 0, 0, this);

int x = topPoint .x - bottomPoint .x;
int y = topPoint .y - bottomPoint .y;

g2d.drawImage(topImg, x, y, this);
g2d.dispose();