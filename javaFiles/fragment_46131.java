class A implements Serializable {
    int x;
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.writeInt(x);
    }
}