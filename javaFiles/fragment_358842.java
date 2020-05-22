ZipInputStream zin…
ZipOutputStream zos=…
byte[] buffer = …

ZipEntry ze = zin.getNextEntry();
while (ze != null) {
  ZipEntry zeOut=new ZipEntry(ze);
  zeOut.setCompressedSize(-1);
  zos.putNextEntry(zeOut);
  int len;
  while ((len = zin.read(buffer)) >= 0) {
     zos.write(buffer, 0, len);
  }
  zos.closeEntry();
  ze = zin.getNextEntry();
}
zos.close();
zin.close();