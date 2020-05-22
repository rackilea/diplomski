private static int[] makeGradientPallet() {
    BufferedImage image = new BufferedImage(100, 1, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2  = image.createGraphics();
    Point start    = new Point(0, 0);
    Point end      = new Point(99, 0);
    float[] dist   = {0.5f, 0.9f, 1.0f};
    Color[] colors = {new Color(99, 190, 123),
                      new Color(255, 235, 132),
                      new Color(248, 105, 107)};
    g2.setPaint(new LinearGradientPaint(start, end, dist, colors));
    g2.fillRect(0, 0, 100, 1);
    g2.dispose();

    int width = image.getWidth(null);
    int[] pallet = new int[width];
    PixelGrabber pg = new PixelGrabber(image, 0, 0, width, 1, pallet, 0, width);
    try {
        pg.grabPixels();
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
    return pallet;
}