public class UnstableDateFormatter implements Formatter<LocalDate> {
  private final List<String> formatsToTry;

  public UnstableDateFormatter(List<String> formatsToTry) {
    this.formatsToTry = formatsToTry;
  }

  @Override
  public LocalDate parse(String text, Locale locale) throws ParseException {
    for (String format : formatsToTry) {
      try {
        return LocalDate.parse(text, DateTimeFormatter.ofPattern(format));
      } catch (DateTimeParseException ignore) {
        // or log the exception
      }
    }
    throw new IllegalArgumentException("Unable to parse \"" + text
        + "\" as LocalDate using formats = " + String.join(", ", formatsToTry));
  }

  @Override
  public String print(LocalDate object, Locale locale) {
    // Implement this method thoroughly
    // If you're accepting dates in different formats which one should be used to print the value?
    return object.toString();
  }
}