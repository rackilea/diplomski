public static String intern(String value) {
    if(value == null) {
        return null;
    }
    return (String) stringPool.add(value);
}