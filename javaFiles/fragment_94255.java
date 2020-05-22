ByteArrayOutputStream bos = new ByteArrayOutputStream();
ObjectOutput out = null;
try {
  out = new ObjectOutputStream(bos);   
  out.writeObject(sealedObject);
  out.flush();
  byte[] yourBytes = bos.toByteArray();
  String base64StringHeader = Base64.encodeBase64String(yourBytes);
} finally {
  try {
    bos.close();
  } catch (IOException ex) {
    // ignore close exception
  }
}