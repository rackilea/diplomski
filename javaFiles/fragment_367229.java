public BufferedImage apply(BufferedImage image) {
int pixel;
BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

for (int y = 0; y < image.getHeight(); y++) {
    for (int x = 0; x < image.getWidth(); x++) {
        pixel = image.getRGB(x, y);

        if (threshold < getAverageRGBfromPixel(pixel)) {
            newImage.setRGB(x, y, new Color(0f, 0f, 0f, 0f).getRGB());
        }
        else {
            // Not sure about this line
            newImage.setRGB(x, y, pixel);
        }
    }
}


return image;