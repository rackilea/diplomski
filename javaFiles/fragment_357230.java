InputStream ins = null;
try {
  ins = conn.getInputStream();
  ...
} finally {
  IOUtils.closeQuietly(ins);
}