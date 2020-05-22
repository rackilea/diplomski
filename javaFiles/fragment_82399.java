int width = 200;
int height = 400;
BufferedImage image = new BufferedImage(width, height,
                          BufferedImage.TYPE_BYTE_BINARY);
Graphics g = image.createGraphics();
g.setColor(Color.WHITE);
g.fillRect(0, 0, width, height);
g.setColor(Color.BLACK);
//ready for drawing