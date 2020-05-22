@Test
public void shouldThrowException() {
    try {
        testSubject.doIt();
        fail("CurrencyConverterException not thrown");
    } catch (CurrencyConverterException e) {
        // expected
        // use this variant if you want to make assertions on the exception, e.g.
        assertTrue(e.getCause() instanceof IllegalAccessException);
    }
}