@Override
public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {

        // get the DownloadManager instance
        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);

        DownloadManager.Query q = new DownloadManager.Query();
        Cursor c = manager.query(q);

        if(c.moveToFirst()) {
            do {
                String name = c.getString(c.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME));
                Log.i("DOWNLOAD LISTENER", "file name: " + name);
            } while (c.moveToNext());
        } else {
            Log.i("DOWNLOAD LISTENER", "empty cursor :(");
        }

        c.close();
    }
}