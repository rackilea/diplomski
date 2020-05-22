import java.lang.reflect.Method;
interface Parent<T extends Number> {
    T foo();
}

interface Child<R extends Integer> extends Parent<R> {
}

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(Child.class.getMethod("foo").getReturnType());
    }
}