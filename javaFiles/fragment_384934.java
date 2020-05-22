class Foo {

    private static int aVariable = 0;

    public static synchronized void increment() { aVariable++; }
    public static synchronized int getVariable() { return aVariable; }

}