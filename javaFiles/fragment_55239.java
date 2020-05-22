int color = bi.getRGB(x, y);

// Components will be in the range of 0..255:
blue[x][y] = color & 0xff;
green[x][y] = (color & 0xff00) >> 8;
red[x][y] = (color & 0xff0000) >> 16;
alpha[x][y] = (color & 0xff000000) >>> 24;