private void saveFile(byte[] zip, String name, String description) throws IOException {
    InputStream is = new ByteArrayInputStream(zip);
    ZipInputStream zis = new ZipInputStream(is);

    Application app = new Application();
    ZipEntry entry = null;
    while ((entry = zis.getNextEntry()) != null) {
        String entryName = entry.getName();
        if (entryName.equals("readme.txt")) { 
           new Scanner(zis); //!!!
           //... 
           zis.closeEntry();