public static HashMap<String, byte[]> test(String zipName) throws Exception {
    HashMap<String, byte[]> returnValue = new HashMap<>();
    FileInputStream fis = new FileInputStream(zipName);
    ZipInputStream zis = new ZipInputStream(
            new BufferedInputStream(fis));
    ZipEntry entry;

    while ((entry = zis.getNextEntry()) != null) {

        int size;
        byte[] buffer = new byte[2048];

        ByteArrayOutputStream baos =
                new ByteArrayOutputStream();
        BufferedOutputStream bos =
                new BufferedOutputStream(baos, buffer.length);

        while ((size = zis.read(buffer, 0, buffer.length)) != -1) {
            bos.write(buffer, 0, size);
        }
        bos.flush();
        bos.close();
        returnValue.put(entry.getName(),baos.toByteArray());
    }

    zis.close();
    fis.close();
    return returnValue;
}