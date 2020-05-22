public void mtdFileEncryption(byte[] myData,String fileName) throws IOException {
    String strLocalFolder = SysProperties.getprocessFile_LOCAL_FOLDER();
    new File(strLocalFolder).mkdir();

    try (FileOutputStream fos = new FileOutputStream(new File(strLocalFolder, fileName)) {
         fos.write(myData);
    }
}