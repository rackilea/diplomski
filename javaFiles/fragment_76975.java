public static <T> T deSerialize(String path, Class<T> clazz) throws IOException {
    try {
        ObjectInputStream o = new ObjectInputStream(new FileInputStream(path));

        return clazz.cast(o.readObject());
    }catch(Exception e) {
        e.printStackTrace();
    }
    return null;
}