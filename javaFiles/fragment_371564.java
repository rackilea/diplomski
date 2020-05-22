public static <T> ArrayList<T> multipleOfSameSet(T object, int setLength) {
    ArrayList<T> out = new ArrayList<T>();
    for(int i = 0; i < setLength; i++) {
        out.add(object);
    }
    return out;
}