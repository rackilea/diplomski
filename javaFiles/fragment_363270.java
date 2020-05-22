// write
ByteArrayOutputStream bos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(bos);
oos.writeObject(mp);
oos.writeObject(mealplan);
oos.close();
byte[] bytes = bos.toByteArray();

// read
ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
ObjectInputStream ois = new ObjectInputStream(bis);
mp = (String) ois.readObject();
mealplan = (String[][][][]) ois.readObject();