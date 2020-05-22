ByteArrayOutputStream bos = new ByteArrayOutputStream();
  ObjectOutputStream oos = new ObjectOutputStream(bos);
  oos.writeObject(map);
  byte[] value = bos.toByteArray();
  oos.close();

  for (byte b : value)
  {
    System.out.print(Integer.toHexString(0xff & b) + " ");
  }
  System.out.println("");

  final ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(value));
  final Object read = ois.readObject();

  System.out.println("read: " + read);