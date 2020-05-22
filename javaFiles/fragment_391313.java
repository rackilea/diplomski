private synchronized void readObject(java.io.ObjectInputStream s)
     throws IOException, ClassNotFoundException
{
    s.defaultReadObject();  // read the fields
    if ((handler = getURLStreamHandler(protocol)) == null) {
        throw new IOException("unknown protocol: " + protocol);
    }
...