private void scanImage(File targetLocation) {
    // Scans the media to load images
    String mimetype = Utility.getMimeType(targetLocation.getAbsolutePath());
    if(mimetype.contains("image"))
    {
        MediaScannerConnection.scanFile(context, new String[] { targetLocation.getPath() }, new String[] { "image/jpeg" }, this);
    }
}