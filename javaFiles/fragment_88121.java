public long startDownload(String downloadurl) {
                DownloadManager downloadManager =
                        (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
                try {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadurl));
// enqueue method retuns downloadId
                    return  downloadManager.enqueue(request);
                } catch (Exception e) {
                    Log.d("DOWNLOADED_INFO", "startDownload =" + e.getMessage());
                    e.printStackTrace();
                }
                return 0;
            }