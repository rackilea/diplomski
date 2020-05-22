Directory directory;
// Keywords
directory = metadata.getDirectory(IptcDirectory.class);
String keywords[] = directory.getStringArray(IptcDirectory.TAG_KEYWORDS);

// Dimensions
directory = metadata.getDirectory(JpegDirectory.class);     
String height = directory.getString(JpegDirectory.TAG_JPEG_IMAGE_HEIGHT);
String width = directory.getString(JpegDirectory.TAG_JPEG_IMAGE_WIDTH);