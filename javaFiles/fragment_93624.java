package test2;

public class Main {
    public static void main(String[] args) throws Exception {
        java.lang.reflect.Constructor<?> bConstructor = Class.forName("test.B").getConstructor(/* parameter types */);
        bConstructor.setAccessible(true);
        Object b = bConstructor.newInstance(/* parameters */);

        java.lang.reflect.Method hello = b.getClass().getMethod("hello");
        hello.setAccessible(true);
        hello.invoke(b);
    }
}