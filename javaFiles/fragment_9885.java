public static void main(String[] args) {
  List<String> list = Arrays.asList("c", "k", "f", "e", "k", "d");
  list.stream()
          .sorted(kFirst())
          .forEach(System.out::print);
}

private static Comparator<? super String> kFirst() {
  return (s1, s2) -> "k".equals(s1) ? -1 : "k".equals(s2) ? 1 : 0;
}