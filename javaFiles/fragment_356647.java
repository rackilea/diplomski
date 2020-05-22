import java.lang.reflect.*;

class A<T> {}
class B extends A<Integer> {}

public class Test {
    public static void main(String[] args) {
        Type type = B.class.getGenericSuperclass();
        ParameterizedType parameterized = (ParameterizedType) type;
        // Prints class java.lang.Integer
        System.out.println(parameterized.getActualTypeArguments()[0]);
    }
}