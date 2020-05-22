ImageInputStream stream = ImageIO.createImageInputStream(res);
Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);

if (readers.hasNext()) {
    ImageReader reader = readers.next();
    reader.setInput(reader);

    int w = reader.getWidth(0);
    int h = reader.getHeight(0);

    ImageReadParam param = reader.getDefaultReadParam();

    NamedImage image = new NamedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    param.setDestination(image);

    /*image = (NamedImage)*/ reader.read(0, param);
}