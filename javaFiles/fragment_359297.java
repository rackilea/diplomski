public final class Ordinals extends java.lang.Enum<Ordinals> {
  public static final Ordinals FIRST;

  public static final Ordinals SECOND;

  public static final Ordinals THIRD;

  private String notation;

  private static final Ordinals[] $VALUES;

  public static Ordinals[] values() {
      return $VALUES.clone();
  }

  public static Ordinals valueOf(String name) {
      return (Ordinals) Enum.valueOf(Ordinals.class, name);
  }

  private Ordinals(String name, int ordinal, String notation) {
      super(name, ordinal);
      this.notation = notation
  }

  static {
      FIRST = new Ordinals("FIRST", 0, "st");
      SECOND = new Ordinals("SECOND", 1, "nd");
      THIRD = new Ordinals("THIRD", 2, "rd");
      Ordinals[] $VALUES = new Ordinals[3];
      $VALUES[0] = FIRST;
      $VALUES[1] = SECOND;
      $VALUES[2] = THIRD;
      Ordinals.$VALUES = $VALUES;
  }
}