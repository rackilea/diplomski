int number = 42;
ByteArrayOutputStream bos = new ByteArrayOutputStream();
ObjectOutputStream os = new ObjectOutputStream(bos);
os.writeObject(number);
String serial = new BASE64Encoder().encode(bos.toByteArray());
os.close();

ByteArrayInputStream bis = new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(serial));
ObjectInputStream is = new ObjectInputStream(bis);