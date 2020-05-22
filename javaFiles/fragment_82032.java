import java.lang.reflect.Method;
import java.util.Arrays;

public class Foo {
    public static void main(String[] args) throws Exception {
        Method square = Arrays.stream(Foo.class.getMethods())
                .filter(m -> m.getName().equals("square"))
                .findFirst().get();
        System.out.println(square);
    }

    public int square(int x) {
        return x * x;
    }
}