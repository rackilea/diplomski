import java.lang.reflect.Method;

public class Foo {
    public static void main(String[] args) throws Exception {
        Method square = Foo.class.getMethod("square", new Class<?>[] { int.class });
        System.out.println(square);
    }

    public int square(int x) {
        return x * x;
    }
}