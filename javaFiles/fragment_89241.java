@Test
public void shouldNotThrowException() {
    try {
        testSubject.convertTo("JPY", 100);
    } catch(CurrencyConverterException e) {
        fail(e.getMessage());
    }
}