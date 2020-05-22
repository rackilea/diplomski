URL url = new URL(link);
URLConnection conn = url.openConnection();
String contentType = conn.getContentType();

String suffix = null;
Iterator<ImageReader> readers =
    ImageIO.getImageReadersByMIMEType(contentType);
while (suffix == null && readers.hasNext()) {
    ImageReaderSpi provider = readers.next().getOriginatingProvider();
    if (provider != null) {
        String[] suffixes = provider.getFileSuffixes();
        if (suffixes != null) {
            suffix = suffixes[0];
        }
    }
}