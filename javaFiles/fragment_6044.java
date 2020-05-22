public static String unsetURLStreamHandlerFactory() {
    try {
        Field f = URL.class.getDeclaredField("factory");
        f.setAccessible(true);
        Object curFac = f.get(null);
        f.set(null, null);
        URL.setURLStreamHandlerFactory(null);
        return curFac.getClass().getName();
    } catch (Exception e) {
        return null;
    }
}