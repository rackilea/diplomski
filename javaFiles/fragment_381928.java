private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException{
    s.defaultWriteObject();
    // extract bytes from bufferedImage and write them
    ...

private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
    s.defaultReadObject();
    // read bytes and re-create bufferedImage
    ...