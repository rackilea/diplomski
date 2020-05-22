public class Something {
  private static final SomeClass staticField = new SomeClass();

  public Something() {
  }

  public static SomeClass getStaticField() {
    return Something.staticField;
  }
}