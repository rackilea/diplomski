byte[] backToBytes = Base64.decodeBase64(base64StringHeader);
ByteArrayInputStream bis = new ByteArrayInputStream(backToBytes);
ObjectInput in = null;
try {
  in = new ObjectInputStream(bis);
  SealedObject = in.readObject(); 
  ...
} finally {
  try {
    if (in != null) {
      in.close();
    }
  } catch (IOException ex) {
    // ignore close exception
  }