@Test public void testConverterException() {
    when(mockMyObject.doSomething1()).thenThrow(MyException.class);
    expected.expect(MyException.class);
    try {
        converter.convert(mockMyObject);
    } finally {
        verify(mockMyObject).doSomething1(); // Now it gets called
    }
}