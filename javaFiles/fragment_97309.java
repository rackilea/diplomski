int color = // your color
int x, y; // used for output
boolean found = false;
for (int ix = 0; ix < bitmap.getWidth(); ++ix) {
  for (int iy = 0; iy < bitmap.getHeight(); ++iy) {
    if (color == bitmap.getPixel(ix, iy) {
      found = true;
      x = ix;
      y = iy;
      break;
    }
  }
}