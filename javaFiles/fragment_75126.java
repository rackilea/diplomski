public static <T> T parseAs(String text, String className) {
    Class clazz;
    FOUND:
    {
        ClassNotFoundException e = null;
        for (String pkg : "java.lang.,java.util.,java.math.,".split(",",-1)) {
            try {
                clazz = Class.forName(pkg + className);
                break FOUND;
            } catch (ClassNotFoundException e2) {
                e = e2;
            }
        }
        throw new IllegalArgumentException(e);
    }
    try {
        Method valueOf = clazz.getMethod("valueOf", String.class);
        return (T) valueOf.invoke(null, text);
    } catch (Exception e) {
        try {
            Constructor<T> valueOf = clazz.getConstructor(String.class);
            return (T) valueOf.newInstance(text);
        } catch (Exception e2) {
            throw new IllegalArgumentException(e);
        }
    }
}

enum BuySell {
    BUY, SELL
}
public static void main(String... args) {
    for (String className : "String,Long,Double,BigDecimal".split(",")) {
        Object o = parseAs("1", className);
        System.out.println(className + " => " + o.getClass() + " as " + o);
    }
    Object o = parseAs("BUY", BuySell.class.getName());
    System.out.println("BuySell => " + o.getClass() + " as " + o);
}