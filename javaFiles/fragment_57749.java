InputStream is = null;
try {
  is = read(filename);
  // Do whatever with is.
} finally {
  IOUtils.closeQuietly(is);
}