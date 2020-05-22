public class OptionalHelper {

    public static <T> Optional<T> findFirstPresent(Supplier<Optional<T>>... optionals) {
        return Arrays.stream(optionals)
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .findFirst()
                .orElse(Optional.empty());
    }
}