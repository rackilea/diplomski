public enum ParserType {

JSON("jsonParser"), XML("xmlParser");

private final String value;

  ParserType(String input) {
     this.value = input;
  }

  public String getValue() {
     return this.value;
  }

  @Override
  public String toString() {
    return this.value;
  }
}