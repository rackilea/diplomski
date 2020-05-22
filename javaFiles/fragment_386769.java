import java.util.function.Consumer;

public class Main {
    public Main() {
    }

    public static void foo(int foo) {
        System.out.println(foo);
    }

    public static void bar(Consumer<Integer> bar) {
        bar.accept(Integer.valueOf(1));
    }

    public static void main(String[] args) {
        bar(Main::foo);
    }
}