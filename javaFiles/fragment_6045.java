public static URLStreamHandler getURLStreamHandler(String protocol) {
    try {
        Method method = URL.class.getDeclaredMethod("getURLStreamHandler", String.class);
        method.setAccessible(true);
        return (URLStreamHandler) method.invoke(null, protocol);        
    } catch (Exception e) {
        return null;
    }
}