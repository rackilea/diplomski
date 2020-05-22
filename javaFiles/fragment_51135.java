Bundle extras = intent.getExtras();
DownloadManager.Query q = new DownloadManager.Query();
q.setFilterById(extras.getLong(DownloadManager.EXTRA_DOWNLOAD_ID));
Cursor c = YOUR_DM.query(q);

if (c.moveToFirst()) {
    int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
    if (status == DownloadManager.STATUS_SUCCESSFUL) {
        // process download
        title = c.getString(c.getColumnIndex(DownloadManager.COLUMN_TITLE));
        // get other required data by changing the constant passed to getColumnIndex
    }
}