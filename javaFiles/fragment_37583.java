public static void main(String[] args) throws Exception {       
    Constructor<?> constructor = Class.forName("java.math.MutableBigInteger").getDeclaredConstructor(int.class);
    constructor.setAccessible(true);
    Object x = constructor.newInstance(new Integer(17));
    Object y = constructor.newInstance(new Integer(19));
    Constructor<?> constructor2 = Class.forName("java.math.MutableBigInteger").getDeclaredConstructor(x.getClass());
    constructor2.setAccessible(true);
    Object z = constructor.newInstance(new Integer(0));
    Object w = constructor.newInstance(new Integer(0));

    Method m = x.getClass().getDeclaredMethod("multiply", new Class[] { x.getClass(), x.getClass()});
    Method m2 = x.getClass().getDeclaredMethod("mul", new Class[] { int.class, x.getClass()});
    m.setAccessible(true);
    m2.setAccessible(true);

    // Slightly faster than BigInteger
    for (int i = 0; i < 200000; i++) {
        m.invoke(x, y, z);
        w = z;
        z = x;
        x = w;
    }

    // Significantly faster than BigInteger and the above loop
    for (int i = 0; i < 200000; i++) {
        m2.invoke(x, 19, x);
    }

    BigInteger n17 = new BigInteger("17");
    BigInteger n19 = new BigInteger("19");
    BigInteger bigX = n17;

    // Slowest
    for (int i = 0; i < 200000; i++) {
        bigX = bigX.multiply(n19);
    }
}