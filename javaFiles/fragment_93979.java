BufferedImage img = ....

public boolean isTransparent( int x, int y ) {
  int pixel = img.getRGB(x,y);
  if( (pixel>>24) == 0x00 ) {
      return true;
  }
  return false;
}