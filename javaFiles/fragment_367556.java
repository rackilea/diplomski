// Inner class containing image information
public static class ImageInformation {
    public final int orientation;
    public final int width;
    public final int height;

    public ImageInformation(int orientation, int width, int height) {
        this.orientation = orientation;
        this.width = width;
        this.height = height;
    }

    public String toString() {
        return String.format("%dx%d,%d", this.width, this.height, this.orientation);
    }
}


public static ImageInformation readImageInformation(File imageFile)  throws IOException, MetadataException, ImageProcessingException {
    Metadata metadata = ImageMetadataReader.readMetadata(imageFile);
    Directory directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
    JpegDirectory jpegDirectory = metadata.getFirstDirectoryOfType(JpegDirectory.class);

    int orientation = 1;
    try {
        orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
    } catch (MetadataException me) {
        logger.warn("Could not get orientation");
    }
    int width = jpegDirectory.getImageWidth();
    int height = jpegDirectory.getImageHeight();

    return new ImageInformation(orientation, width, height);
}