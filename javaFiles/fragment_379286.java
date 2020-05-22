@ParameterizedTest
@MethodSource(names = "createInterfaceImplAndCheckValue")
void testValue(MyInterface impl, Object value) { 
    assertEquals(impl.getValue(),value)
}

private static Stream<Arguments> createInterfaceImplAndCheckValue() {
    return Stream.of(
            ObjectArrayArguments.create(new MyInterfaceImpl1(), "hi"),
            ObjectArrayArguments.create(new MyInterfaceImpl2(), 7));
}

@ParameterizedTest
@MethodSource(names = "createInterfaceImplAndTimeout")
void testPerformance(MyInterface impl, int timeout) { 
        assertTimeout(ofMillis(timeout), () -> impl.value());
}

private static Stream<Arguments> createInterfaceImplAndTimeout() {
    return Stream.of(
            ObjectArrayArguments.create(new MyInterfaceImpl1(), 1),
            ObjectArrayArguments.create(new MyInterfaceImpl2(), 13));
}