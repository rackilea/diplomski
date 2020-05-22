public static BufferedImage toBinaryImage(final BufferedImage image) {
    final BufferedImage blackAndWhiteImage = new BufferedImage(
            image.getWidth(null), 
            image.getHeight(null), 
            BufferedImage.TYPE_BYTE_BINARY);
    final Graphics2D g = (Graphics2D) blackAndWhiteImage.getGraphics();
    g.drawImage(image, 0, 0, null);
    g.dispose();
    return blackAndWhiteImage;
}