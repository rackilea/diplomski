public static void main(String[] args) throws IOException {
    ZipFile zipFile = new ZipFile("C:/test.zip");

    Enumeration<? extends ZipEntry> entries = zipFile.entries();

    while(entries.hasMoreElements()){
        ZipEntry entry = entries.nextElement();
        InputStream stream = zipFile.getInputStream(entry);
    }
}