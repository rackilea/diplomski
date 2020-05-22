@SuppressWarnings("unchecked")
public static <T extends Serializable> T unserial(byte[] b, Class<T> cl) throws IOException, ClassNotFoundException {
    try (ByteArrayInputStream bis = new ByteArrayInputStream(b)) {
        ObjectInput in = null;
        in = new ObjectInputStream(bis);
        return (T) in.readObject();
    }
}