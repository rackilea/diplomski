public static void main(String[] args) {
    Stream.of("Testing")
          .flatMap(s -> permutation(s).stream())
          .flatMap(s -> substrings(s).stream())
          .distinct()
          .forEach(System.out::println);
}