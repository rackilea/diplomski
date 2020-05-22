private static final int[] RGB_MASKS = {0xFF0000, 0xFF00, 0xFF};
private static final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
...

BufferedImage image = componentToImage(imagePanel, true);
saveJPeg(image, "c:/saved.jpg");

private void saveJPeg(BufferedImage image, String name) {
    PixelGrabber pg = new PixelGrabber(image, 0, 0, -1, -1, true);
    try {
        pg.grabPixels();
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
    int width = pg.getWidth(), height = pg.getHeight();

    DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(), pg.getWidth() * pg.getHeight());
    WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
    BufferedImage bi = new BufferedImage(RGB_OPAQUE, raster, false, null);

    try {
        ImageIO.write(bi, "jpg", new File(name));
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}