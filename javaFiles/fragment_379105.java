public static void downloadFile(String fileURL, String fileName) {
    try {
        // fileURL=fileURL.replaceAll("amp;", "");
        Log.e(fileURL, fileName);
        String RootDir = Environment.getExternalStorageDirectory()
                .toString();

        File RootFile = new File(RootDir);
        new File(RootDir + Commons.dataPath).mkdirs();
        File file = new File(RootFile + Commons.dataPath + fileName);
        if (file.exists()) {

            file.delete();
        }
        file.createNewFile();

        URL u = new URL(fileURL);
        HttpURLConnection c = (HttpURLConnection) u.openConnection();
        c.setRequestMethod("GET");
        c.setDoOutput(true);
        c.connect();
        FileOutputStream f = new FileOutputStream(new File(
                "mnt/sdcard"+Commons.dataPath + fileName));
        InputStream in = c.getInputStream();
        byte[] buffer = new byte[1024];
        int len1 = 0;

        while ((len1 = in.read(buffer)) > 0) {
            f.write(buffer, 0, len1);
        }
        f.close();

    } catch (Exception e) {

        e.printStackTrace();
    }

}