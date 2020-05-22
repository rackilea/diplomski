public static byte[] serial(Serializable s) throws IOException {
    try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutput out = new ObjectOutputStream(bos)) {
        out.writeObject(s);
        out.flush();
        return bos.toByteArray();
    }
}