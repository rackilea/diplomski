public class InvalidAgesException extends IllegalArgumentException {
    private final List<Integer> invalidAges;

    public InvalidAgesException(List<Integer> invalidAges) {
        this.invalidAges = invalidAges;
    }

    public List<Integer> getInvalidAges() {
        return invalidAges;
    }
}

public static void checkAge(int[] ages) {
    List<Integer> invalidAges = IntStream.of(ages)
        .filter(age -> age < 18)
        .boxed()
        .collect(Collectors.toList());

    throw new InvalidAgesException(invalidAges);
}