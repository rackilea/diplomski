public static java.io.File createFileFromURL(String fileURL, String fileName) throws IOException {

    java.io.File tempFile = null;

    try {
        URL url = new URL(fileURL);
        Logger.info("GoogleControl: createFileFromURL: url = " + url);
        Logger.info("GoogleControl: createFileFromURL: fileName = " + fileName);
        String filePrefix = StringControl.left(fileName, ".") + "_";
        String fileExt = "." + StringControl.rightBack(fileName, ".");
        Logger.info("GoogleControl: createFileFromURL: filePrefix = " + filePrefix);
        Logger.info("GoogleControl: createFileFromURL: fileExt = " + fileExt);

        tempFile = java.io.File.createTempFile(filePrefix, fileExt);

        tempFile.deleteOnExit();
        FileUtils.copyURLToFile(url, tempFile);
        Logger.info("GoogleControl: createFileFromURL: tempFile name = " + tempFile.getName());
    } catch (Exception ex) {
        System.out.println(ex.toString());
        ex.printStackTrace();
    }

    return tempFile;
}