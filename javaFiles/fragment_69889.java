ByteArrayInputStream bis = new ByteArrayInputStream(yourBytes);
ObjectInput in = null;
try {
  in = new ObjectInputStream(bis);
  Object o = in.readObject(); 
  ...
} finally {
  try {
    if (in != null) {
      in.close();
    }
  } catch (IOException ex) {
    // ignore close exception
  }
}