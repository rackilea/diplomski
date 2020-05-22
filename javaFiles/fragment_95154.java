try {
    int array[][][] = new int[param][][];
    Serializer s = new Serializer();
    byte [] b = s.serialize(array);
    Object arrayCopy = (int[][][]) s.deserialize(b);
} catch(IOException ioe) {
    // ... handle this
} catch(ClassNotFoundException cnfe) {
    // ... handle this
}