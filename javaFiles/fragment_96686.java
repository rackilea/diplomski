public ObjectInputStream(InputStream in) throws IOException {
    verifySubclass();
    bin = new BlockDataInputStream(in);
    handles = new HandleTable(10);
    vlist = new ValidationList();
    enableOverride = false;
    readStreamHeader();
    bin.setBlockDataMode(true);
}