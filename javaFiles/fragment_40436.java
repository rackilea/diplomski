public static byte[] objectToByteArray(Object obj) throws Exception {
    byte[] bytes = null;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(obj);
    bytes = baos.toByteArray();
    oos.close();
    return bytes;
}

public static Object byteArrayToObject(byte[] buffer) throws Exception {
    Object ob = null;
    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(
            buffer));
    ob = ois.readObject();
    ois.close();
    return ob;
}