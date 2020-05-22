private static void subtractImages(BufferedImage image1, BufferedImage image2) throws IOException {
    BufferedImage image3 = new BufferedImage(image1.getWidth(), image1.getHeight(), image1.getType());
    int color;
    for(int x = 0; x < image1.getWidth(); x++)
        for(int y = 0; y < image1.getHeight(); y++) {
            color = Math.abs(image2.getRGB(x, y) - image1.getRGB(x, y));                
            image3.setRGB(x, y, color);
        }
    ImageIO.write(image3, "bmp",  new File("image.bmp"));
 }