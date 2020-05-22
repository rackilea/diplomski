private Bitmap getVideoFrame(Uri uri, long timeInUSeconds) {
    MediaMetadataRetriever retriever = new MediaMetadataRetriever();
    retriever.setDataSource(this, uri);
    synchronize (this) {
        Bitmap temp = retriever.getFrameAtTime(timeInUSeconds, MediaMetadataRetriever.OPTION_CLOSEST);
    }
    retriever.release();
    return temp;
}