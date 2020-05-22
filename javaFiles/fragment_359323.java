public static void main(String... ignore) {
    int i = convertTo("10", int.class);
    String s = convertTo(true, String.class);
    BigDecimal bd = convertTo(1.2345, BigDecimal.class);
    System.out.println("i=" + i + ", s=" + s + ", bd=" + bd);
}

private static final Map<Class, Class> WRAPPER_MAP = new LinkedHashMap<Class, Class>();

static {
    WRAPPER_MAP.put(boolean.class, Boolean.class);
    WRAPPER_MAP.put(byte.class, Byte.class);
    WRAPPER_MAP.put(char.class, Character.class);
    WRAPPER_MAP.put(short.class, Short.class);
    WRAPPER_MAP.put(int.class, Integer.class);
    WRAPPER_MAP.put(float.class, Float.class);
    WRAPPER_MAP.put(long.class, Long.class);
    WRAPPER_MAP.put(double.class, Double.class);
}

public static <T> T convertTo(Object o, Class<T> tClass) {
    if (o == null) return null;
    String str = o.toString();
    if (tClass == String.class) return (T) str;
    Class wClass = WRAPPER_MAP.get(tClass);
    if (wClass == null) wClass = tClass;
    try {
        try {
            return (T) wClass.getMethod("valueOf", String.class).invoke(null, str);
        } catch (NoSuchMethodException e) {
            return (T) wClass.getConstructor(String.class).newInstance(str);
        }
    } catch (Exception e) {
        throw new AssertionError(e);
    }
}