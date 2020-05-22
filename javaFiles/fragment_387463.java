BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 

  for (int y = 0; y < height; y++) {
     for (int x = 0; x < width; x++) {
        int rgb = r[y][x];
        rgb = (rgb << 8) + g[y][x]; 
        rgb = (rgb << 8) + b[y][x];
        image.setRGB(x, y, rgb);
     }
  }

  File outputFile = new File("/output.bmp");
  ImageIO.write(image, "bmp", outputFile);