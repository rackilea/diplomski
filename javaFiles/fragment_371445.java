InputStream is = getClass().getResourceAsStream("my_embedded_file.zip");
ZipInputStream zis = new ZipInputStream(is);
ZipEntry entry;

while ((entry = zis.getNextEntry()) != null) {
    // do something with the entry - for example, extract the data 
}