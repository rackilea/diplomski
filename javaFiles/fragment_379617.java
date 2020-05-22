public enum Jenum {
  FOO("foo"), BAR("bar");

  private final String value;
  Jenum(String value) { this.value = value; }

  public String getValue() { return value; }
}