Object obj = ...  // object to copy

ObjectOutputStream out = new ObjectOutputStream(new ByteArrayOutputStream());
out.writeObject(obj);
byte[] bytes = baos.toByteArray();

ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
Object copy = in.readObject();