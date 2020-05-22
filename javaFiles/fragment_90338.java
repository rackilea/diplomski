FileOutputStream fos = new FileOutputStream(path);
  Cipher c = ...
  CipherOutputStream cos = new CipherOutputStream(fos, c);
  ObjectOuputStream oos = new ObjectOuputStream(baos);

  oos.writeObject(someObject);
  oos.close();