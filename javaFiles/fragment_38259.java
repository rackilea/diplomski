static <T extends Number> T[] parseBulk(String bulk, Class<T> type, Function<String,T> parser) {
    String[] elements = bulk.split(";");
    T[] result = (T[])Array.newInstance(type, elements.length);
    for (int i= 0; i< elements.length; i++) {
        result[i] = parser.apply(elements[i]);
    }
    return result;
}