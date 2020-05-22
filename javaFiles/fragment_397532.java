public static void unzipFile(File zipFile) throws IOException {
    File destDir = new File(zipFile.getParentFile(), Files.getNameWithoutExtension(zipFile.getName()));
    try(ZipInputStream zipStream = new ZipInputStream(new FileInputStream(zipFile))) {
        ZipEntry zipEntry = zipStream.getNextEntry();
        if(zipEntry == null) throw new IOException("Empty or no zip-file");
        while(zipEntry != null) {
            File destination = new File(destDir, zipEntry.getName());
            if(zipEntry.isDirectory()) {
                destination.mkdirs();
            } else {
                destination.getParentFile().mkdirs();
                Files.asByteSink(destination).writeFrom(zipStream);
            }
            zipEntry = zipStream.getNextEntry();
        }
    }
}