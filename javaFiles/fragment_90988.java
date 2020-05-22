File imageFile = new File(filename);
Iterator<ImageReader> imageReaders = ImageIO.getImageReadersByFormatName("jpeg");
if ( imageReaders.hasNext() ) {
    imageReader = (ImageReader)imageReaders.next();
    stream = ImageIO.createImageInputStream(imageFile);
    imageReader.setInput(stream, true);
    ImageReadParam param = imageReader.getDefaultReadParam();
    curImage = imageReader.read(0, param);
}