public static void main(String[] args) throws IOException {
    byte[] originalBytesArray = Files.readAllBytes(new File("OrdLog.BR-1.17.2016-09-12.bin").toPath());
    byte[] bytesArray = Files.readAllBytes(new File("OrdLog.BR-1.17.2016-09-12.bin.gz").toPath());
    DataInputStream reader = null;
    try {
        reader = new DataInputStream(new GZIPInputStream(new ByteArrayInputStream(bytesArray)));
        System.out.println("gzip");
    } catch (ZipException notZip) {
        reader = new DataInputStream(new ByteArrayInputStream(bytesArray));
        System.out.println("no gzip");
    }
    byte[] uncompressedBytesArray = new byte[originalBytesArray.length];
    reader.readFully(uncompressedBytesArray);
    reader.close();
    boolean filesDiffer = false;
    for (int i = 0; i < uncompressedBytesArray.length; i++) {
        if (originalBytesArray[i] != uncompressedBytesArray[i]) {
            filesDiffer = true;
        }
    }
    System.out.println("Files differ: " + filesDiffer);
}