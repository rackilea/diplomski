Region r = . . .;
ByteArrayOutputStream bos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(bos);
oos.writeObject(r);
oos.close();
ObjectInputStream ois = new ObjectInputStream(
    new ByteArrayInputStream(bos.getBytes()));
Region r2 = (Region) ois.readObject();
// voilà - a very expensive clone()!