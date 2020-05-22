// Get a pixel
int rgb = bufferedImage.getRGB(x, y);

// Get all the pixels
int w = bufferedImage.getWidth(null);
int h = bufferedImage.getHeight(null);
int[] rgbs = new int[w*h];
bufferedImage.getRGB(0, 0, w, h, rgbs, 0, w);