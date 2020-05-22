public static int getStatus(Context context , long downloadId) {
    DownloadManager downloadManager =
            (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
    DownloadManager.Query query = new DownloadManager.Query();
    query.setFilterById(downloadId);// filter your download bu download Id
    Cursor c = downloadManager.query(query);
    if (c.moveToFirst()) {
        int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
        c.close();
        Log.i("DOWNLOAD_STATUS", String.valueOf(status));
        return status;
    }
    Log.i("AUTOMATION_DOWNLOAD", "DEFAULT");
    return -1;
}