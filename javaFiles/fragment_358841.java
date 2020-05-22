ZipFile zf = …
ZipOutputStream zos = …
byte[] buffer = …

for(Enumeration<? extends ZipEntry> e=zf.entries(); e.hasMoreElements();) {
  ZipEntry ze = e.nextElement();
  InputStream is = zf.getInputStream(ze);
  ZipEntry zeOut=new ZipEntry(ze);
  zeOut.setCompressedSize(-1);
  zos.putNextEntry(zeOut);
  int len;
  while ((len = is.read(buffer)) >= 0) {
     zos.write(buffer, 0, len);
  }
  zos.closeEntry();
}
zos.close();
zf.close();