public Image changedImageAlpha(Image image, int trans) {
    BufferedImage img = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = img.createGraphics(); 
    Composite c = AlphaComposite.getInstance( AlphaComposite.SRC_ATOP, .5f); 
    g.setComposite(c); 
    g.drawImage(image, 0, 0, null);
    g.dispose();

    return img;
}