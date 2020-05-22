public void encode(File file, OutputStream base64OutputStream) {
  InputStream is = new FileInputStream(file);
  OutputStream out = new Base64OutputStream(base64OutputStream)
  IOUtils.copy(is, out);
  is.close();
  out.close();
}