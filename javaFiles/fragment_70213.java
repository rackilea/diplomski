public static void main(String[] args) {
    try {
        String t = getObject(String.class);
        Integer d = getObject(Integer.class);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static <T> T getObject(Class<T> returnType) throws Exception {
    if(returnType == String.class) {
        return (T) "test";
    } else if(returnType == Integer.class) {
        return (T) new Integer(0);
    } else {
        return (T) returnType.newInstance();
    }
}