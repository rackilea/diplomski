ByteArrayOutputStream bos = new ByteArrayOutputStream();
ObjectOutputStream out = null;
try {
  out = new ObjectOutputStream(bos);   
  out.writeObject(yourObject);
  out.flush();
  byte[] yourBytes = bos.toByteArray();
  ...
} finally {
  try {
    bos.close();
  } catch (IOException ex) {
    // ignore close exception
  }
}