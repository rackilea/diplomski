public class EscapingLikeExpression extends LikeExpression {
  public EscapingLikeExpression(String propertyName, String value) {
      super(propertyName, escapeString(value), '!', false);
  }

  static String escapeString(String inputString) {
    inputString = inputString.replace("_", "!_");
    return inputString;
  }

}