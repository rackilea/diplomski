int w = image.getWidth();
int h = image.getHeight();
BufferedImage imageNew = null;
if (imageSource.matches(".*jpg$")) {
    imageNew = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
} else if (imageSource.matches(".*png$")) {
    imageNew = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);
} else {
    // whatever
}
imageNew.setData(Raster.createRaster(imageNew.getSampleModel(), new DataBufferByte(pixelsBinNew, pixelsBinNew.length), new Point()));