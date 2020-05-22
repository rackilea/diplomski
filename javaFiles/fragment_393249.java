private Object convertFromBytes(byte[] value) throws IOException, ClassNotFoundException {
    try (InputStream is = new ByteArrayInputStream(value);
         ObjectInputStream ois = new ObjectInputStream(is)) {
        return ois.readObject();
    }
}

private byte[] convertToBytes(Object object) throws IOException {
    try (ByteArrayOutputStream os = new ByteArrayOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(os)) {
        oos.writeObject(object);
        oos.flush();
        return os.toByteArray();
    }
}