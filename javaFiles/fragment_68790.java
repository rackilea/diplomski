public enum NumberEnum {
  ZERO ("zero"),
  ONE ("one"),
  TWO ("two"),
  THREE ("three"),
  FOUR ("four"),
  FIVE ("five"),
  SIX ("six"),
  SEVEN ("seven"),
  EIGHT ("eight"),
  NINE ("nine"),
  TEN ("ten");

  private String text;
  private static final NumberEnum[] elements = NumberEnum.class.getEnumConstants();

  private NumberEnum(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public static NumberEnum getFromDigit(int index) {
    if (index < 0 || index > 9) return null;
    return elements[index];
  }
}