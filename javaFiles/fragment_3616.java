ZipEntry dataZE;
InputStream isData = getClass().getResourceAsStream("/" + dataName + ".zip");
StringBuffer sbData = new StringBuffer();
ZipInputStream dataZIS = new ZipInputStream(isData);
while ((dataZE = dataZIS.getNextEntry()) != null) {
    // do something...
    dataZIS.closeEntry();
}