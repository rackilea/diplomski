public void copyImage(Image image) {
    if (image != null) {
        this.width = image.getWidth(null);
        this.height = image.getWidth(null);

        BufferedImage bi = (BufferedImage) image;
        Graphics g = getGraphics();

        g.drawImage(bi, 0, 0, width, height, null);
    }
}