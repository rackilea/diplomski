File folder = new File(Environment.getExternalStorageDirectory() + "/any");
            if (!folder.exists()) {
                folder.mkdir();
            }
DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
request.setDestinationInExternalPublicDir("/Download/Global Mp3", nameOfFile);