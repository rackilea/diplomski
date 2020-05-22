File file = new File( "test.zip" );
ZipFile zipFile = new ZipFile(file);

Enumeration enumeration = zipFile.entries();
while (enumeration.hasMoreElements()) {
    ZipEntry zipEntry = (ZipEntry) enumeration.nextElement();
    System.out.println(zipEntry.getSize()); // prints the size
}