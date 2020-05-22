static final int R = 0xFF000000;
static final int G = 0x00FF0000;
static final int B = 0x0000FF00;

  pixmap.setColor(setColor);
  for (int y = 0; y < pixmap.getHeight(); y++) {
        for (int x = 0; x < pixmap.getWidth(); x++) {
            int pixel = pixmap.getPixel(x, y);

            if((pixel & R) != R || (pixel & B) != B && (pixel & G) != G){
                pixmap.drawPixel(x, y);
            }
        }
    }