public class FunctionalUtils {
    public static <T> Function1<T, Unit> fromConsumer(Consumer<T> callable) {
        return t -> {
            callable.accept(t);
            return Unit.INSTANCE;
        };
    }
}