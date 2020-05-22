byte[] getPrivateKeyAsSuperUser() {

    byte[] data = null;
    try {
        MainActivity.rootLatch.await();
    } catch (InterruptedException e) {
        Log.d(MainActivity.mainActivity.getPackageName(), e.getLocalizedMessage());
    }
    Su su = Su.getStaticInstance();
        try {
            su.outputStream.writeBytes(String.format("cat \"%s\"\n", sshPrivateKey.getAbsolutePath()));
            su.outputStream.flush();
            data = readStream(su.inputStream);
        } catch (IOException e) {
            Log.d(MainActivity.mainActivity.getPackageName(), e.getLocalizedMessage());
        }
    return data;

}