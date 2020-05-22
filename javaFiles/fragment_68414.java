public void changeImageSizeDynmcally(int x, int y) {

    AREA_WIDTH = x;
    AREA_HEIGHT = y;
    repaint();

    scaledImage = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2D = scaledImage.createGraphics();
    g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2D.drawImage(image,0,0, null);

    g2D.dispose();
    setImage(scaledImage); //this is a new method!
}`