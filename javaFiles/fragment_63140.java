public final String TAG = getClass().getSimpleName();
public void startLocalServer(int port, String root, Boolean localhost, Boolean keepAlive) {
        try {
            String[] filePathList = (getAssets().list("www"));
            Log.e(TAG,"-------Assets List-----");
            for (String s : filePathList) {
                Log.e(TAG, s);
            }
            File externalCache = getExternalCacheDir();
            if (externalCache != null) {
                String path = externalCache.getAbsolutePath() + "/" + root;
                copyFolderFromAssets(getApplicationContext(), "www", path);
                File www_root = new File(path);
                Log.e(TAG,"-------Root File List-----");
                for (File f : www_root.listFiles()) {
                    Log.e("File ", f.getAbsolutePath());
                }
                server = new WebServer("localhost", port, www_root.getCanonicalFile());
                server.start();
                printIp();
            }

        } catch (IOException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }

    public void copyFolderFromAssets(Context context, String rootDirFullPath, String targetDirFullPath) {
        Log.e(TAG,"copyFolderFromAssets " + "rootDirFullPath-" + rootDirFullPath + " targetDirFullPath-" + targetDirFullPath);
        File file = new File(targetDirFullPath);
        if (!file.exists()) {
            new File(targetDirFullPath).mkdirs();
        }
        try {
            String[] listFiles = context.getAssets().list(rootDirFullPath);// 遍历该目录下的文件和文件夹
            for (String string : listFiles) {// 看起子目录是文件还是文件夹，这里只好用.做区分了
                if (isFileByName(string)) {// 文件
                    copyFileFromAssets(context, rootDirFullPath + "/" + string, targetDirFullPath + "/" + string);
                } else {// 文件夹
                    String childRootDirFullPath = rootDirFullPath + "/" + string;
                    String childTargetDirFullPath = targetDirFullPath + "/" + string;
                    new File(childTargetDirFullPath).mkdirs();
                    copyFolderFromAssets(context, childRootDirFullPath, childTargetDirFullPath);
                }
            }
        } catch (IOException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }


    public void copyFileFromAssets(Context context, String assetsFilePath, String targetFileFullPath) {
        InputStream assestsFileInputStream;
        try {
            assestsFileInputStream = context.getAssets().open(assetsFilePath);
            FileOutputStream fOS = new FileOutputStream(new File(targetFileFullPath));
            int length = -1;
            byte[] buf = new byte[1024];
            while ((length = assestsFileInputStream.read(buf)) != -1) {
                fOS.write(buf, 0, length);
            }
            fOS.flush();
        } catch (IOException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }

    private boolean isFileByName(String str) {
        return str.contains(".");
    }

    private void printIp() {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
        final String formatedIpAddress = String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff),
                (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));
        Log.e(TAG,"Connected : " + "Please access! http://" + formatedIpAddress + ":" + server.getListeningPort() + " From a web browser");
    }