import java.lang.reflect.Constructor;
import java.util.Arrays;

class Example
{
    public Example(String a) {
        System.out.println("(String): " + a);
        // ...
    }

    public Example(int a, String b) {
        System.out.println("(int, String): " + a + ", " + b);
        // ...
    }

    public Example(String a, String b) {
        System.out.println("(String, String): " + a + ", " + b);
        // ...
    }

    static Example create(Object... params) {
        try {
            Class[] paramTypes = new Class[params.length];
            for (int n = 0; n < params.length; ++n) {
                Class cls = params[n].getClass();
                if (cls.equals(Integer.class)) { // You may need this (for int and other primitives)
                    paramTypes[n] = Integer.TYPE;
                } else {
                    paramTypes[n] = cls;
                }
            }
            Constructor ctor = Example.class.getConstructor(paramTypes);
            return (Example)ctor.newInstance(params);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
            throw new IllegalArgumentException("parameters not supported");
        }
    }

    public static void main(String[] args)
    {
        Example e1 = Example.create("foo");
        Example e2 = Example.create(1, "foo");
        Example e3 = Example.create("foo", "bar");
    }
}