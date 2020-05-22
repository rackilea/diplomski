sp<MediaMetadataRetriever> mRetriever(new MediaMetadataRetriever);
int fd = open(path, O_RDONLY | O_LARGEFILE);
status_t status;
if (fd < 0) {
    // couldn't open it locally, maybe the media server can?
    status = mRetriever->setDataSource(path);
} else {
    status = mRetriever->setDataSource(fd, 0, 0x7ffffffffffffffL);
    close(fd);
}
if (status) {
    return MEDIA_SCAN_RESULT_ERROR;
}