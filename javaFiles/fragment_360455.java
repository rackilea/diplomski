// save object to file
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/tmp/file")));
oos.writeObject(myArray); // where myArray is String[]

// load object from file
ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("/tmp/file")));
String[] read = (String[]) ois.readObject();