// ITS PSEUDOCODE!!

private InputStream extractOnlyFile(String path) {
   ZipFile zf = new ZipFile(path);
   Enumeration e = zf.entries();
   ZipEntry entry = (ZipEntry) e.nextElement(); // your only file
   return zf.getInputStream(entry);
}