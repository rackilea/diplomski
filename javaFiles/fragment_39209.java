public Image changedImageAlpha(Image image, int trans) {
    BufferedImage img = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = img.createGraphics(); 
    Composite c = AlphaComposite.getInstance( AlphaComposite.SRC_ATOP, .5f); 
    g.setComposite(c); 
    g.drawImage(image, 0, 0, null);
    g.dispose();

    int colorMask = 0x00FFFFFF;
    int alphaShift = 24;
    for(int y=0; y<img.getHeight(); y++){
        for(int x=0; x<img.getWidth(); x++) {
            img.setRGB(x, y, (img.getRGB(x, y) & colorMask) | (trans << alphaShift));
        }
    }
    return img;
}