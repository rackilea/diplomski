public abstract class Optional<T> {

    public static <O> Optional<O> createEmptyOption() {
        return new EmptyOptional<>();
    }
}