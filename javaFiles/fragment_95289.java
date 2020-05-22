public static int sizeof(Object obj) throws IOException {

    ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);

    objectOutputStream.writeObject(obj);
    objectOutputStream.flush();
    objectOutputStream.close();

    return byteOutputStream.toByteArray().length;
}