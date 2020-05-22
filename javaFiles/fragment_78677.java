private Pixmap rotatePixmap (Pixmap srcPix){
    final int width = srcPix.getWidth();
    final int height = srcPix.getHeight();
    Pixmap rotatedPix = new Pixmap(height, width, srcPix.getFormat());

    for (int x = 0; x < height; x++) {
        for (int y = 0; y < width; y++) {
            rotatedPix.drawPixel(x, y, srcPix.getPixel(y, x));
        }
    }

    srcPix.dispose();
    return rotatedPix;
}