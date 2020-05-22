public void demo() {
    String test1 = "parameter1";
    String test2 = "parameter2";
    String test3 = "parameter3";
    List<String> validValuesforTest1 = Arrays.asList(new String[] { "test1", "test11" });
    List<String> validValuesforTest2 = Arrays.asList(new String[] { "test2" });
    List<String> validValuesforTest3 = Arrays.asList(new String[] { "test3", "test33", "test33" });

    combine(
        Arrays.asList(validValuesforTest1, validValuesforTest2, validValuesforTest3),
        Arrays.asList(test1, test2, test3),
        new StringBuilder());
}