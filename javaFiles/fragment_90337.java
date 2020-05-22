ByteArrayOutputStream baos = new ByteArrayOutputStream();
  ObjectOuputStream oos = new ObjectOuputStream(baos);

  oos.writeObject(someObject);
  oos.close();

  byte[] serialized = baos.toByteArray();