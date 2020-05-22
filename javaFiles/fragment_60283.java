public static BufferedImage getBufferedImage(Image img) {
    if (img == null) {
        return null;
    }
    int w = img.getWidth(null);
    int h = img.getHeight(null);
    // draw original image to thumbnail image object and 
    // scale it to the new size on-the-fly 
    BufferedImage bufimg = new BufferedImage(w, h, 
        BufferedImage.TYPE_INT_RGB);
    Graphics2D g2 = bufimg.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(img, 0, 0, w, h, null);
    g2.dispose();
    return bufimg;
}