private static void writeFile(FileOutputStream fos, String zipFilePath) throws IOException {
    byte[] buffer = new byte[12048];
    try (InputStream fis = new FileInputStream(zipFilePath);
         InputStream inflaterInputStream = new GZIPInputStream(fis)) {
         int data;
         while ((data = inflaterInputStream.read(buffer)) != -1) {//with buffer**
             fos.write(buffer, 0, data);
         }
    }
}