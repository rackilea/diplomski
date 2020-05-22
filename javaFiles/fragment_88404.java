// Bob sends
Base base = // some Base class
objectOutputStream.writeObjec(base);

// Alice receives
Base base = (Base) objectInputStream.readObject();