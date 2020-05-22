private static int getCompression(RenderedOp op) throws Exception {
int TAG_COMPRESSION = 259;
TIFFDirectory dir = (TIFFDirectory)op.getProperty("tiff_directory");
if(dir.isTagPresent(TAG_COMPRESSION)) {
TIFFField compField = dir.getField(TAG_COMPRESSION);
return compField.getAsInt(0);
}
return 0;
}