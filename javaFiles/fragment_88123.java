public static boolean checkStatus(Context context , int status) {
        DownloadManager downloadManager = (DownloadManager)
                context.getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Query query = new DownloadManager.Query();

        query.setFilterByStatus(status);
        Cursor c = downloadManager.query(query);
        if (c.moveToFirst()) {
            c.close();
            Log.i("DOWNLOAD_STATUS", String.valueOf(status));
            return true;
        }
        Log.i("AUTOMATION_DOWNLOAD", "DEFAULT");
        return false;
    }