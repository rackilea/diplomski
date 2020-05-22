public static File copyFile(ApplicationInfo appInfo, File folderName, String apkName) {

    File initialFile = new File(appInfo.getSourceDir());
    File finalFile = new File(folderName, apkName);

    try {
        FileInputStream inStream = new FileInputStream(initialFile);
        FileOutputStream outStream = new FileOutputStream(finalFile);
        FileChannel inChannel = inStream.getChannel();
        FileChannel outChannel = outStream.getChannel();
        inChannel.transferTo(0, inChannel.size(), outChannel);
        inStream.close();
        outStream.close();

    } catch (IOException e) {
        e.printStackTrace();
    }

    return finalFile;
}