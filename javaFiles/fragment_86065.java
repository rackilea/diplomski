ZipFile zf = new ZipFile(file);
try {
  InputStream in = zf.getInputStream(zf.getEntry("file.txt"));
  // ... read from 'in' as normal
} finally {
  zf.close();
}