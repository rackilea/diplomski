private static void writeFile(FileOutputStream fos, String zipFilePath) throws IOException {
    try (InputStream fis = new FileInputStream(zipFilePath);
         InputStream inflaterInputStream = new GZIPInputStream(fis)) {
        IOUtils.copy(fis, fos);
    }
}