private void configureImageViews() {

    String path = externalDirectory() + File.separatorChar
            + "sushi_plate_tokyo_20091119.png";

    ImageView fullImageView = (ImageView) findViewById(R.id.fullImageView);
    ImageView bitmapRegionImageView = (ImageView) findViewById(R.id.bitmapRegionImageView);

    Bitmap fullBitmap = null;
    Bitmap regionBitmap = null;

    try {
        BitmapRegionDecoder bitmapRegionDecoder = BitmapRegionDecoder
                .newInstance(path, false);

        // Get the width and height of the full image
        int fullWidth = bitmapRegionDecoder.getWidth();
        int fullHeight = bitmapRegionDecoder.getHeight();

        // Get a bitmap of the entire image (full plate of sushi)
        Rect fullRect = new Rect(0, 0, fullWidth, fullHeight);
        fullBitmap = bitmapRegionDecoder.decodeRegion(fullRect, null);

        // Get a bitmap of a region only (eel only)
        Rect regionRect = new Rect(275, 545, 965, 1025);
        regionBitmap = bitmapRegionDecoder.decodeRegion(regionRect, null);

    } catch (IOException e) {
        // Handle IOException as appropriate
        e.printStackTrace();
    }

    fullImageView.setImageBitmap(fullBitmap);
    bitmapRegionImageView.setImageBitmap(regionBitmap);

}

// Get the external storage directory
public static String externalDirectory() {
    File file = Environment.getExternalStorageDirectory();
    return file.getAbsolutePath();
}