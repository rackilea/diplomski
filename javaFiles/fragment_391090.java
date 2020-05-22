public enum Type {
  CSV, EXCEL, PDF, URL; // Note the absence of NULL/NONE/WHATEVER
  public static Optional<Type> from(String text) {
    return Optional.ofNullable(text)
      .map(String::toUpperCase)
      .map(Type::valueOf);
  }
}