try {
    int length = 0;
    newFile.createNewFile();

    InputStream inputStream = ctx.getAssets().open(
            "myBigFile.apk");
    FileOutputStream fOutputStream = new FileOutputStream(
            newFile);
    //note the following line
    byte[] buffer = new byte[1024];
    while ((length = inputStream.read(buffer)) > 0) {
        fOutputStream.write(buffer, 0, length);
    }
    fOutputStream.flush();
    fOutputStream.close();
    inputStream.close();
} catch (Exception ex) {
    if (ODP_App.getInstance().isInDebugMode())
        Log.e(TAG, ex.toString());
}