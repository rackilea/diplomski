import java.lang.reflect.Constructor;
import java.util.Arrays;

class Example
{
    public Example(String a) {
        System.out.println("one param: " + a);
        // ...
    }

    public Example(String a, String b) {
        System.out.println("two params: " + a + ", " + b);
        // ...
    }

    public Example(String a, String b, String c) {
        System.out.println("three params: " + a + ", " + b + ", " + c);
        // ...
    }

    static Example create(String... strings) {
        try {
            Class[] paramTypes = new Class[strings.length];
            Arrays.fill(paramTypes, String.class);
            Constructor ctor = Example.class.getConstructor(paramTypes);
            return (Example)ctor.newInstance((Object[])strings);
        } catch (Exception e) {
            throw new IllegalArgumentException(strings.length + " strings not supported");
        }
    }

    public static void main (String[] args)
    {
        Example e = Example.create("a", "b", "c");
    }
}