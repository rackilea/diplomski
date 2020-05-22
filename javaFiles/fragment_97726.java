NumberFormatter
  .withLocale(...)
  .unit(Currency.getInstance("USD"))
  .sign(SignDisplay.AUTO) // "123", "0", and "-123"
  .format(123)
  .toString();