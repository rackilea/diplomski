public static BufferedImage isolateBlueChannelAndResize(BufferedImage image) {
    int imageWidth  = image.getWidth();
    int imageHeight = image.getHeight();
    // Round down for odd-sized images to prevent indexing outside image
    if ((imageWidth  & 1) > 0) imageWidth --;
    if ((imageHeight & 1) > 0) imageHeight--;

    BufferedImage newImage = new BufferedImage(imageWidth/2, imageHeight/2, image.getType());

    for (int i = 0; i < imageWidth; i += 2) {
        for (int j = 0; j < imageHeight; j += 2) {
            int r1 = (image.getRGB(i  , j  ) >> 16) & 0xff;
            int r2 = (image.getRGB(i+1, j  ) >> 16) & 0xff;
            int r3 = (image.getRGB(i  , j+1) >> 16) & 0xff;
            int r4 = (image.getRGB(i+1, j+1) >> 16) & 0xff;
            int red = (r1 + r2 + r3 + r4 + 3) / 4;   // +3 rounds up (equivalent to ceil())

            int g1 = (image.getRGB(i  , j  ) >>  8) & 0xff;
            int g2 = (image.getRGB(i+1, j  ) >>  8) & 0xff;
            int g3 = (image.getRGB(i  , j+1) >>  8) & 0xff;
            int g4 = (image.getRGB(i+1, j+1) >>  8) & 0xff;
            int green = (g1 + g2 + g3 + g4 + 3) / 4;   // +3 rounds up (equivalent to ceil()) 

            newImage.setRGB(i/2, j/2, (red << 16) | (green << 8));
        }
    }

    return newImage;
}