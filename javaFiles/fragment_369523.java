int pixels = 0;
for(int y = 0; y < height; y++){
  for(int x = 0; x < width; x++){
    int p = 0;
    if (pixels < pixelsLimit) {
        int a = 255;//(int)(Math.random()*256); //alpha
        int r = (int)(Math.random()*256); //red
        int g = (int)(Math.random()*256); //green
        int b = (int)(Math.random()*256); //blue
        p = (a<<24) | (r<<16) | (g<<8) | b; //pixel
    }
    img.setRGB(x, y, p);
    ++pixels;
  }
}