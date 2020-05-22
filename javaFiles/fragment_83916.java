public static void main(String... ignored) {
    List<String> s = new ArrayList<>();
    s.add("hello");

    Predicate<? super String> predicate1 = (t) -> t.length() > 0;
    Predicate<? super String> predicate2 = (t) -> t.length() < 8;
    Predicate<? super String> predicate3 = null;

    List<String> collect = s.stream()
            .filter(predicate1) // 16
            .filter(predicate2) // 17
            .filter(predicate3) // 18
            .collect(Collectors.toList());
}