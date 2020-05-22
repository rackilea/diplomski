@ParameterizedTest
@MethodSource("doThingsProvider")
void doThings (String valInput, int expectedCode) {         
      when(foo.getVal()).thenReturnEach(valInput);
      String response = myService.doThings(foo);
      Assert.assertEqual(expectedCode, response);      
}

static Stream<Arguments> doThingsProvider() {
    return Stream.of(
        Arguments.of("A", 200),
        Arguments.of("B", 404),
        Arguments.of("C", 200),
    );
}