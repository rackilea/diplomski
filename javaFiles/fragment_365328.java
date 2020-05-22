import java.util.function.Consumer;

public static void main(String[] args) {
    String message = "Hello World";
    executeLambda(message, value -> print(value));
}

public static void executeLambda(String value, Consumer<String> lambda) {
    lambda.accept(value);
}