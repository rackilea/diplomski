Arrays.stream(ArrayOfFiles).parallel().forEach(file -> {
    String extension = ...;
    if (ext.contains(extension)) {
        // Must init in side loop
        MediaMetadataRetriever iLoveThisThing = new MediaMetadataRetriever();
        iLoveThisThing.setDataSource(fileString);
        String mime = iLoveThisThing.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE);
        ...
        audioFileSet.add(file);
        // Dont forget to release resource:
        iLoveThisThing.release();
    }
});