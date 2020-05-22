private static Object deserialize(String s) throws IOException,
        ClassNotFoundException {
    byte[] data = Base64.getDecoder().decode(s);
    ObjectInputStream ois = new ObjectInputStream(
            new ByteArrayInputStream(data));
    Object o = ois.readObject();
    ois.close();
    return o;
}