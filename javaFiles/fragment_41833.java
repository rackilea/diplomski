private static Boolean isBlank(PDPage pdfPage) throws IOException {
    BufferedImage bufferedImage = pdfPage.convertToImage();
    long count = 0;
    int height = bufferedImage.getHeight();
    int width = bufferedImage.getWidth();
    Double areaFactor = (width * height) * 0.99;

    for (int x = 0; x < width ; x++) {
        for (int y = 0; y < height ; y++) {
            Color c = new Color(bufferedImage.getRGB(x, y));
            // verify light gray and white
            if (c.getRed() == c.getGreen() && c.getRed() == c.getBlue()
                    && c.getRed() >= 248) {
                 count++;
            }
        }
    }

    if (count >= areaFactor) {
        return true;
    }

    return false;
}