BufferedImage original = ImageIO.read(new File(file.getPath()));

    image= new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
    image.getGraphics().drawImage(original, 0, 0, null);
     for(int y = 0; y < original.getHeight(); y++){
            for(int x = 0; x < original.getWidth(); x++){
                image.setRGB(x,y, original.getRGB(x,y));
            }
     }