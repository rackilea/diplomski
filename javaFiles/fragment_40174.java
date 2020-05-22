final List<MyClass> list;

try (
    final Stream<String> lines = Files.lines(...);
) {
    list = lines.parallel().map(MyClass::new)
        .collect(seeAbove);
}