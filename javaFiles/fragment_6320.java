public static void main(String... arg) {
    dropWhile(n -> n < 3, Stream.of(0, 1, 2, 3, 0, 1, 2, 3, 4))
      .forEach(System.out::println);
}
static <T> Stream<T> dropWhile(Predicate<T> p, Stream<T> s) {
    class MutableBoolean { boolean b; }
    MutableBoolean inTail = new MutableBoolean();
    return s.filter(i -> inTail.b || !p.test(i) && (inTail.b = true));
}