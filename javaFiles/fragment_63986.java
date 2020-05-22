File input = new File("/tmp/input.gif");
      File output = new File("/tmp/output.png");
      BufferedImage im1 = ImageIO.read( input );
      BufferedImage im2 = new BufferedImage(im1.getWidth(), im1.getHeight(), 
                BufferedImage.TYPE_4BYTE_ABGR);
      im2.getGraphics().drawImage(im1, 0, 0, null);
      ImageIO.write(im2 , "png", output);