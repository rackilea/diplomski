public void cancelDownload(View view) {
    //downloadReference= intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0);
    //downloadReference = dm.enqueue(request);
    dm.remove(enqueue );

    Toast.makeText(DownloadManagerActivity.this, "Download Cancelled", Toast.LENGTH_SHORT).show();

}