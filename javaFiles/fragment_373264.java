public class UnstableDateFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<UnstableDateFormats> {
  @Override
  public Set<Class<?>> getFieldTypes() {
    return Collections.singleton(LocalDate.class);
  }

  @Override
  public Printer<?> getPrinter(UnstableDateFormats annotation, Class<?> fieldType) {
    return new UnstableDateFormatter(Arrays.asList(annotation.formatsToTry()));
  }

  @Override
  public Parser<?> getParser(UnstableDateFormats annotation, Class<?> fieldType) {
    return new UnstableDateFormatter(Arrays.asList(annotation.formatsToTry()));
  }
}