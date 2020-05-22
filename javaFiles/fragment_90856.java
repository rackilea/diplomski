public static void addToZip(File file, ZipOutputStream zos) throws FileNotFoundException, IOException {

    System.out.println("Writing '" + fileName + "' to zip file");

    FileInputStream fis = new FileInputStream(file);
    ZipEntry zipEntry = new ZipEntry(file.getName());
    zos.putNextEntry(zipEntry);

    byte[] bytes = new byte[1024];
    int length;
    while ((length = fis.read(bytes)) >= 0) {
        zos.write(bytes, 0, length);
    }

    zos.closeEntry();
    fis.close();

}