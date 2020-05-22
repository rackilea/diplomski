public static void main(final String[] args) {
  final Optional<Integer> valid = Optional.of("42")
      .transform(STR_TO_INT_FUNCTION)
      .or(Optional.<Integer>absent());
  System.out.println(valid); // Optional.of(42)
  final Optional<Integer> invalid = Optional.of("Toto")
      .transform(STR_TO_INT_FUNCTION)
      .or(Optional.<Integer>absent());
  System.out.println(invalid); // Optional.absent()
  final Optional<Integer> absent = Optional.<String>absent()
      .transform(STR_TO_INT_FUNCTION)
      .or(Optional.<Integer>absent());
  System.out.println(absent); // Optional.absent()
}

private static final Function<String, Optional<Integer>> STR_TO_INT_FUNCTION =
    new Function<String, Optional<Integer>>() {
      @Override
      public Optional<Integer> apply(final String input) {
        return Optional.fromNullable(Ints.tryParse(input));
      }
    };