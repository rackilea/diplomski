import java.util.Arrays;

class App {
    public static void main(String[] args) {
        Arrays.stream(args).forEach(System.out::println);
    }
}