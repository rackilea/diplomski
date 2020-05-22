// Create input stream
try (ImageInputStream input = ImageIO.createImageInputStream(file)) {
    // Get the reader
    Iterator<ImageReader> readers = ImageIO.getImageReaders(input);

    if (!readers.hasNext()) {
        throw new IllegalArgumentException("No reader for: " + file);
    }

    ImageReader reader = readers.next();

    try {
        reader.setInput(input);

        // Optionally, listen for read warnings, progress, etc.
        reader.addIIOReadWarningListener(...);
        reader.addIIOReadProgressListener(...);

        ImageReadParam param = reader.getDefaultReadParam();

        // Note: For some formats (ie. GIF), finding the number of images
        // requires searching the entire stream. In this case, it may 
        // be more convenient to just read until you get an IndexOutOfBoundsException
        for (int i = 0; i < reader.getNumImages(true); i++) {
            // Optionally, control read settings like sub sampling, source region or destination etc.
            param.setSourceSubsampling(...);
            param.setSourceRegion(...);
            param.setDestination(...);
            // ...

            // Finally read the image, using settings from param
            BufferedImage image = reader.read(i, param);

            // Optionally, read thumbnails, meta data, etc...
            int numThumbs = reader.getNumThumbnails(0);
            // ...
        }
    }
    finally {
        // Dispose reader in finally block to avoid memory leaks
        reader.dispose();
    }
}