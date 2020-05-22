try (InputStream in = ...;
     OutputStream out = ...) {
  byte[] buffer = new byte[1024];
  while (in.read(buffer) >= 0)
    out.write(buffer);
} catch (IOException ex) {
  ...
}