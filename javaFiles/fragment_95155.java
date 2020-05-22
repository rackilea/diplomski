public class Serializer {

    public <T> byte[] serialize(T obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }

    public <T> T deserialize(Class<T> clazz, byte[] bytes) throws IOException,
            ClassNotFoundException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        final Object raw = o.readObject();
        if (raw.getClass().isAssignableFrom(clazz))
            return clazz.cast(raw);
        else
            throw new IllegalArgumentException(
                    "Byte data does not represent a class of type " + clazz);
    }
}