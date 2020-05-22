public static BufferedImage textEffect(BufferedImage image, BufferedImage text) {
    if (image.getWidth() != text.getWidth() ||
        image.getHeight() != text.getHeight())
    {
        throw new IllegalArgumentException("Dimensions are not the same!");
    }
    BufferedImage img = new BufferedImage(image.getWidth(),
                                          image.getHeight(),
                                          BufferedImage.TYPE_INT_ARGB_PRE);

    for (int y = 0; y < image.getHeight(); ++y) {
        for (int x = 0; x < image.getWidth(); ++x) {
           int textPixel = text.getRGB(x, y);
           int textAlpha = (textPixel & 0xFF000000);
           int sourceRGB = image.getRGB(x, y);
           int newAlpha = (int) (((textAlpha >> 24) * (sourceRGB >> 24)) / 255d);
           int imgPixel = (newAlpha << 24) |  (sourceRGB & 0x00FFFFFF);
           int rgb = imgPixel | textAlpha;
           img.setRGB(x, y, rgb);

        }
    }
    return img;
}