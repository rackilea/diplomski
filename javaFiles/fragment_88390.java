@ParameterizedTest
@MethodSource("dummyFunction")
void functionName(String s1, String s2) {
    System.out.println("s1 = [" + s1 + "], s2 = [" + s2 + "]");
}

static Stream<Arguments> dummyFunction() {
    List<String> list1 = List.of("1", "2", "3");
    List<String> list2 = List.of("a", "b", "c");

    Assertions.assertEquals(list1.size(), list2.size());

    List<Arguments> arguments = new ArrayList<>();
    for (int i = 0; i < list1.size(); i++) {
        arguments.add(Arguments.of(list1.get(i), list2.get(i)));
    }

    return arguments.stream();
}