public enum Type {
  CSV, EXCEL, PDF, URL, NONE;
  public static Type from(String text) {
    if (text == null) {
      return NONE;
    } else {
      return valueOf(text.toUpperCase());
    }
  }
}