for (int y = 0; y < image.getHeight(); ++y) {
    for (int x = 0; x < image.getWidth(); ++x) {
         int argb = image.getRGB(x, y);
         if ((argb & 0x00FFFFFF) == 0x00D67FFF)
         {
              image.setRGB(x, y, 0);
         }
    }
}