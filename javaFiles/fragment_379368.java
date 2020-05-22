private File exportFile(File src, File dst) throws IOException {

    //if folder does not exist
    if (!dst.exists()) {
        if (!dst.mkdir()) {
            return null;
        }
    }

    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    File expFile = new File(dst.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
    FileChannel inChannel = null;
    FileChannel outChannel = null;

    try {
        inChannel = new FileInputStream(src).getChannel();
        outChannel = new FileOutputStream(expFile).getChannel();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    try {
        inChannel.transferTo(0, inChannel.size(), outChannel);
    } finally {
        if (inChannel != null)
            inChannel.close();
        if (outChannel != null)
            outChannel.close();
    }

    return expFile;
}