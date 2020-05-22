@Test
public void test() {
    BigDecimalValidator validator = CurrencyValidator.getInstance();

    BigDecimal amount = validator.validate("$123.00", Locale.US);
    assertNotNull(amount);

    //remove the brackets since this is something unusual
    String in = "$(123.00)".replaceAll("\\(", "").replace(')', ' ').trim();
    amount = validator.validate(in, Locale.US);
    assertNotNull(amount);

    amount = validator.validate("invalid", Locale.US);
    assertNull(amount);
}