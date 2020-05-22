Icon icon = null;
BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
Graphics2D g2d = img.createGraphics();
icon.paintIcon(null, g2d, 0, 0);
g2d.dispose();

try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
    ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
    try {
        ImageIO.write(img, "png", ios);
        // Set a flag to indicate that the write was successful
    } finally {
        ios.close();
    }
    byte[] bytes = baos.toByteArray();
} catch (IOException ex) {
    ex.printStackTrace();
}