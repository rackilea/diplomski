downloadManager = new DownloadManager(new DownloadManager.DownloadCompleteListener(){
    @Override
    public void getProgress(double progress, long downloadedBytes, long sizeInBytes){

    }

    @Override
    public void onDownloadComplete(Uri fileLocalUri, long downloadedFileId){

    }
});
downloadManager.download(Uri uri, String fileName, String description);