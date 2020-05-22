File externalCache = getExternalCacheDir();
if (externalCache != null) {
    String path = externalCache.getAbsolutePath() + "/" + root;
    File www_root = new File(path);
    copyFolderFromAssets(getApplicationContext(), "www", path);
    Log.e(TAG,"-------Root File List-----");
    for (File f : www_root.listFiles()) {
        Log.e("File ", f.getAbsolutePath());
    }
    server = new WebServer("localhost", port, www_root.getCanonicalFile());
    server.start();
    printIp();
}