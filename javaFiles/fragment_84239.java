int rgb = img.getRGB(x, y);
int alpha = (rgb >>> 24);
int r = (rgb >> 16) & 0xFF;
int g = (rgb >> 8) & 0xFF;
int b = (rgb & 0xFF);

int newColour = (alpha << 24) + (r << 16) + (g << 8) + (b << 4);