import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        doThat(1, 2, 3, 4, 5);
    }

    public static void doThat(Object... varargs) {
        doThis(varargs);
    }

    public static void doThis(Object... varargs) {
        System.out.println(Arrays.toString(varargs));
    }
}