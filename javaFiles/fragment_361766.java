/**
 * Load a scaled sub-TIFF image.  Loads nth sub-image and scales to given width; preserves aspect ratio.
 * 
 * @param fileName String filename
 * @param index Index of sub-TIFF; will throw ArrayIndexOutOfBoundsException if sub-image doesn't exist
 * @param w Desired width of image; height will scale
 * @return Image (BufferedImage)
 * @throws IOException
 * @throws ImageReadException
 */
public static Image loadScaledSubTIFF(String fileName, int index, int w) throws IOException, ImageReadException {
    File imageFile = new File(fileName);
    ByteSourceFile bsf = new ByteSourceFile(imageFile);
    FormatCompliance formatCompliance = FormatCompliance.getDefault();
    TiffReader tiffReader = new TiffReader(true);
    TiffContents contents = tiffReader.readDirectories(bsf, true, formatCompliance);
    TiffDirectory td = contents.directories.get(index);
    Image bi = td.getTiffImage(tiffReader.getByteOrder(), null);
    Object width = td.getFieldValue(new TagInfo("", 256, TiffFieldTypeConstants.FIELD_TYPE_SHORT) {/**/});
    Object height = td.getFieldValue(new TagInfo("", 257, TiffFieldTypeConstants.FIELD_TYPE_SHORT) {/**/});
    int newWidth = w;
    int newHeight = (int) ((newWidth * ((Number)height).doubleValue()) / (((Number)width).doubleValue()));

    bi = bi.getScaledInstance(w, newHeight, java.awt.Image.SCALE_FAST);
    height = null;
    width = null;
    td = null;
    contents = null;
    tiffReader = null;
    formatCompliance = null;
    bsf = null;
    return bi;
}