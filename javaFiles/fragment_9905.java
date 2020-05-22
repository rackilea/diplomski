public static Object readFile(URL url) throws IOException, ClassNotFoundException {
    ObjectInputStream is = new ObjectInputStream(url.openStream());
    Object o = is.readObject();
    is.close();
    return o;
}