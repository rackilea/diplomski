@ParameterizedTest
@MethodSource(names = "createInterfaceImplAndCheckValue")
void testValue(MyInterface impl, Object value, int timeout) { 
    assertEquals(impl.getValue(),value)
}


@ParameterizedTest
@MethodSource(names = "createInterfaceImplAndCheckValue")
void testPerformance(MyInterface impl, Object value, int timeout) { 
        assertTimeout(ofMillis(timeout), () -> impl.value());
}

private static Stream<Arguments> createInterfaceImplAndCheckValue() {
    return Stream.of(
            ObjectArrayArguments.create(new MyInterfaceImpl1(), "hi", 1),
            ObjectArrayArguments.create(new MyInterfaceImpl2(), 7, 12));
}