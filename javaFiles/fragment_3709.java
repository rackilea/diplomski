class SpreadInvoker {
    public static void draw1(int x, String y) {
        System.out.printf("draw1(%s, %s)%n", x, y);
    }

    public void draw2(int x, int y) {
        System.out.printf("draw2(%s, %s)%n", x, y);
    }

    static MethodHandle DRAW1;
    static MethodHandle DRAW2;

    public static void main(String[] args) throws Throwable {
        DRAW1 = MethodHandles.lookup()
                             .findStatic(
                                 SpreadInvoker.class,
                                 "draw1",
                                 MethodType.methodType(
                                     void.class,
                                     int.class,
                                     String.class
                                 )
                             )
                             .asSpreader(Object[].class, 2);

        DRAW2 = MethodHandles.lookup()
                             .findVirtual(
                                 SpreadInvoker.class,
                                 "draw2",
                                 MethodType.methodType(
                                     void.class,
                                     int.class,
                                     int.class
                                 )
                             ).asSpreader(Object[].class, 2);

        SpreadInvoker instance = new SpreadInvoker();

        final Object[] args1 = { 13, "twenty-six" };
        final Object[] args2 = { 13, 26 };

        DRAW1.invoke(args1);           // SpreadInvoker.draw1(13, "twenty-six")
        DRAW2.invoke(instance, args2); // instance.draw2(13, 26)
    }
}