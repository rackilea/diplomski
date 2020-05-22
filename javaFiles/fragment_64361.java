public byte[]tiffToPng(byte[]tiffBytes) throws IOException {
    SeekableStream stream = new ByteArraySeekableStream(tiffBytes);
    ImageDecoder decoder = ImageCodec.createImageDecoder("tiff", stream, null);
    RenderedImage tiffRenderedImage = decoder.decodeAsRenderedImage(0);

    BufferedImage tiffBufferedImage = toBufferedImage(tiffRenderedImage);
    for (int y = 0; y < tiffBufferedImage.getHeight(); y++) {
        for (int x = 0; x < tiffBufferedImage.getWidth(); x++) {
            int rgb = tiffBufferedImage.getRGB(x, y);
            int a = (rgb>>24)&0xFF;
            int r = (rgb>>16)&0xFF;
            int g = (rgb>>8)&0xFF;
            int b = (rgb>>0)&0xFF;
            if(a == 0xFF && r == g && g == b) {
                if(r < 254) {
                    tiffBufferedImage.setRGB(x, y, 0xFF000000);
                } else {
                    tiffBufferedImage.setRGB(x, y, 0xFFFFFFFF);
                }
            }
        }
    }

    PNGEncodeParam pngEncodeParam = PNGEncodeParam.getDefaultEncodeParam(tiffBufferedImage);
    pngEncodeParam.setBitDepth(1);
    ByteArrayOutputStream pngBytesStream = new ByteArrayOutputStream();
    ImageEncoder encoder = ImageCodec.createImageEncoder("png", pngBytesStream, pngEncodeParam);
    encoder.encode(tiffBufferedImage);
    pngBytesStream.flush();
    return pngBytesStream.toByteArray();
}

public BufferedImage toBufferedImage(RenderedImage img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        ColorModel cm = img.getColorModel();
        int width = img.getWidth();
        int height = img.getHeight();
        WritableRaster raster = cm.createCompatibleWritableRaster(width, height);
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        Hashtable properties = new Hashtable();
        String[] keys = img.getPropertyNames();
        if (keys != null) {
            for (int i = 0; i < keys.length; i++) {
                properties.put(keys[i], img.getProperty(keys[i]));
            }
        }
        BufferedImage result = new BufferedImage(cm, raster, isAlphaPremultiplied, properties);
        img.copyData(raster);
        return result;
    }