@TestFactory
@Execution(ExecutionMode.CONCURRENT)
DynamicNode dynamicNodeSingleContainer() {
    return dynamicContainer("palindromes",
        Stream.of("racecar", "radar", "mom", "dad")
            .map(text -> dynamicTest(text, () -> {
                assertTrue(isPalindrome(text));
                System.err.println(Thread.currentThread().getName());
            })
    ));
}