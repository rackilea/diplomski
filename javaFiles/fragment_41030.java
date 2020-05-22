package def;

import java.lang.reflect.Method;

import abc.B;

public class C {
    public static void main(String[] args) throws Exception {
        Method m = B.class.getMethod("foo");
        m.invoke(new B());
    }
}