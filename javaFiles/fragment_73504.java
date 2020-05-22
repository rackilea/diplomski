static Image getImage(File file) {
    ImageIcon systemIcon = (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(file);
    java.awt.Image image = systemIcon.getImage();
    if (image instanceof BufferedImage) {
        return new Image(display, convertToSWT((BufferedImage)image));
    }
    int width = image.getWidth(null);
    int height = image.getHeight(null);
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = bufferedImage.createGraphics();
    g2d.drawImage(image, 0, 0, null);
    g2d.dispose();
    return new Image(display, convertToSWT(bufferedImage));
}