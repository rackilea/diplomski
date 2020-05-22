FileOutputStream fos = new FileOutputStream("t.tmp");
ObjectOutputStream oos = new ObjectOutputStream(fos);

Map m = new Map();

// set Map properties ...

oos.writeObject(m);
oos.close();