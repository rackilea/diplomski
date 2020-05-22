javap -private Foo

Compiled from "Foo.java"
final class Foo extends java.lang.Enum<Foo> {
  public static final Foo BAR;
  public static final Foo BAZ;
  private static final Foo[] $VALUES;
  public static Foo[] values();
  public static Foo valueOf(java.lang.String);
  private Foo();
  static {};
}